package tests.selenidehw;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("HomeWork")

public class HwPracticeFormTest {

//https://demoqa.com/automation-practice-form

    @BeforeAll
    static void beforeAll() {
       Configuration.browserSize = "1920x1080";
       Configuration.baseUrl = "https://demoqa.com";

    }

        @Test
        void practiceFormTest() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Vasya");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("VasyaPupkin@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("2028")).click();
        $(".react-datepicker__month-container").$(byText("15")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile (new File("src/test/resources/--44.jpeg"));
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Vasya Pupkin"), text("VasyaPupkin@mail.ru"),
                text("Female"), text("8800555353"), text("15 May,2028"), text("English"),
                text("Sports"), text("--44.jpeg"), text("Russia"), text("Uttar Pradesh Lucknow"));
        sleep(6000);

        }

}



