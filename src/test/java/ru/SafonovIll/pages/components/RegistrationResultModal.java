package ru.SafonovIll.pages.components;

import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Tag("HomeWork")

public class RegistrationResultModal {

    public RegistrationResultModal verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationResultModal verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}