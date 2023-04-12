package tests.WorkingWithFileHW;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileParsingTest {

    ClassLoader cl = FileParsingTest.class.getClassLoader();


    @Test
    void ExelParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("TestZip.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().equals("ExelTest.xls")) {
                    XLS xls = new XLS(zs);
                    assertEquals("Для",
                            xls.excel.getSheetAt(0).getRow(0).getCell(0).getBooleanCellValue()
                    );
                    assertEquals("теста",
                            xls.excel.getSheetAt(0).getRow(1).getCell(1).getBooleanCellValue()
                    );
                    assertEquals("Exel",
                            xls.excel.getSheetAt(0).getRow(2).getCell(2).getBooleanCellValue()
                    );
                    assertEquals("файла",
                            xls.excel.getSheetAt(0).getRow(3).getCell(3).getBooleanCellValue()
                    );

                }
            }
        }
    }

    @Test
    void CsvParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("TestZip.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("Test.csv")) {
                    InputStreamReader isr = new InputStreamReader(zis);
                    CSVReader csv = new CSVReader(isr);
                    var content = csv.readAll();
                    assertEquals(new String[]{"1,Для"}, content.get(0));
                    assertEquals(new String[]{"2,теста"}, content.get(1));
                    assertEquals(new String[]{"3,Csv"}, content.get(2));
                    assertEquals(new String[]{"4,Файла"}, content.get(3));

                }
            }
        }
    }

    @Test
    void PdfParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("TestZip.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("pdf-sample.pdf")) {
                    PDF pdf = new PDF(zis);
                    assertEquals(pdf.numberOfPages, 1);
                    assertEquals("Для теста PDF файла", pdf.content);
                }
            }
        }
    }

    @Test
    void readJsonFileTest() throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("ClientCard.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            Bank bank = mapper.readValue(isr, Bank.class);
            assertEquals("Ilya",bank.nameClient);
            assertEquals("12345",bank.loginClient);

            Map<String, Object> cards = bank.getCards();
            assertEquals(1, cards.size());
            List<String> testCards = Arrays.asList("Visa", "MasterCard");
            assertEquals(testCards, cards.get("name"));


        }
    }
}





