package tests.hwselenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HwSelenideDragAndDropTest {
    @BeforeAll
    static void beforeAll()  {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldNotHave(text("A"));
        sleep(7000);

    }
    @Test
    void practiceDragAndDropTwo(){
        //Тест падает
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 0).release().perform();
        $("#column-a").shouldNotHave(text("A"));

    }

}
