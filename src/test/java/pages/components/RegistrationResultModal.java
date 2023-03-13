package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    public void verifyModal() {
        $(".modal-body").shouldHave(text("Vasya Pupkin"), text("VasyaPupkin@mail.ru"),
                text("Female"), text("8800555353"), text("25 May,2015"), text("English"),
                text("Sports"), text("--44.jpeg"), text("Russia"), text("Uttar Pradesh Lucknow"));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

}
