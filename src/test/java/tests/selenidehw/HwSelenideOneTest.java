package tests.selenidehw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("TelegramBot")


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
        $(".markdown-body").
                shouldHave(text(" Configuration.assertionMode = SOFT"));

//
//
//
//
//
//
//
//
//
//
//                .shouldHave(text("""
//                        @ExtendWith({SoftAssertsExtension.class})
//                        class Tests {
//                          @Test
//                          void test() {
//                            Configuration.assertionMode = SOFT;
//                            open("page.html");
//
//                            $("#first").should(visible).click();
//                            $("#second").should(visible).click();
//                          }
//                        }"""));

        }

    }
