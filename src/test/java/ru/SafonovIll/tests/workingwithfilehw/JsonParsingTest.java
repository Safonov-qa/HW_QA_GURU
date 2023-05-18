package ru.SafonovIll.tests.workingwithfilehw;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParsingTest {


    ClassLoader cl = FileParsingTest.class.getClassLoader();


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


