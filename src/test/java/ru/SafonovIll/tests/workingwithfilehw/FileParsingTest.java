package ru.SafonovIll.tests.workingwithfilehw;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static org.junit.jupiter.api.Assertions.*;


public class FileParsingTest {

    ClassLoader cl = FileParsingTest.class.getClassLoader();


    @Test
    void exelParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("TestZip.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().equals("ExelTest.xlsx")) {
                    XLS xls = new XLS(zs);
                    assertTrue(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()
                            .startsWith("Для")
                    );
                    assertTrue(xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()
                            .startsWith("Теста")
                    );
                    assertTrue(xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue()
                            .startsWith("Exel")
                    );
                    assertTrue(xls.excel.getSheetAt(0).getRow(3).getCell(3).getStringCellValue()
                            .startsWith("файла")
                    );
//
                    return;

                }
            }
              fail("File not found");
        }
    }


    @Test
    void csvParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("TestZip.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().equals("TestCSV.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zs));
                    List<String[]> string = csvReader.readAll();
                    assertArrayEquals(new String[] {"Для теста CSV Файла"}, string.get(0));
                    return;
                }
            }
            fail("File not found");
        }
    }

    @Test
    void pdfParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("TestZip.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("TestPdf.pdf")) {
                    PDF pdf = new PDF(zis);
                    assertEquals(2, pdf.numberOfPages);
                    assertTrue(pdf.text.contains("Для теста PDF файла"));
                    return;
                }
            }
            fail("File not found");
        }
    }

}





