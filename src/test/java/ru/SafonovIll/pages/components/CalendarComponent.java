package ru.SafonovIll.pages.components;

import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Tag("HomeWork")

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month-container").$(byText(day)).click();
    }
}
