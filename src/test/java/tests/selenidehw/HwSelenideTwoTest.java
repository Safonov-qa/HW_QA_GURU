package tests.selenidehw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("TelegramBot")


public class HwSelenideTwoTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void practiceTestGithubTwo() {

        open("https://github.com/");

        $(".header-menu-wrapper").find(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));


        sleep(6000);
    }

}
