package tests.javaFakerAndPageObjectHW;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selenide.*;

public class HwPageObjectTest extends TestBase {

RegistrationPage registrationPage = new RegistrationPage();
RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @Test
    void practiceFormTest() {

        String userName = "Vasya";
        String lastName = " Pupkin";
        String userEmail = "VasyaPupkin@mail.ru";
        String userNumber = "8800555353";
        String gender = "Female";
        String day = "25";
        String month = "May";
        String year = "2015";
        String subject = "English";
        String hobbies = "Sports";
        String picture = "--44.jpeg";
        String currentAddress = "Russia";
        String state = "Uttar Pradesh";
        String city = "Lucknow";


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthday(day, month,year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)

                .clickSubmit();

        registrationResultModal.verifyResult("Student Name", userName + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year )
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city );

        sleep(2000);
    }

}

