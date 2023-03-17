package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static com.codeborne.selenide.Selenide.sleep;
import static tests.TestData.*;


public class HwJavaFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


        @Test
        void practiceFormTest() {

            registrationPage
                    .openPage()
                    .removeBanner()
                    .setFirstName(userName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthday(day, month, year)
                    .setSubject(subject)
                    .setHobbies(hobbies)
                    .setPicture()
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();

            registrationPage
                    .verifyResult("Student Name", userName + " " + lastName)
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



