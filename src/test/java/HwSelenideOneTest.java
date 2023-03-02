import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HwSelenideOneTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void practiceTestGithub() {
        open("https://github.com/");

        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".Box-row.wiki-more-pages-link").$("button").click();
        $(".Layout-sidebar").shouldHave(text("SoftAssertions"));
        $(".Box.Box--condensed.color-shadow-small").$(byText("SoftAssertions")).click();
        $("#js-repo-pjax-container").shouldHave(text("Using JUnit5 extend test class"));


        }

    }
