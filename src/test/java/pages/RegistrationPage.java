package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("HomeWork")

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();


    private final String
            REMOVE_BANNER_INPUT = "$('#fixedban').remove()",
            REMOVE_FOOTER_INPUT = "$('footer').remove()",
            ADDRESS_REGISTRATION_FORM = "/automation-practice-form";

    private  final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput =  $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthdayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {

        open(ADDRESS_REGISTRATION_FORM);

        return this;
    }

    public RegistrationPage removeBanner() {
        Selenide.executeJavaScript(REMOVE_BANNER_INPUT);
        Selenide.executeJavaScript(REMOVE_FOOTER_INPUT);

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthday(String day, String month, String year) {
        dateOfBirthdayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;

    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;

    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();


        return this;

    }

    public void clickSubmit() {
        submitButton.click();


    }

}


