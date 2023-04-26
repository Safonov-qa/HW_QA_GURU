package tests.javafakerandpageobjecthw;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;
import utils.StudentData;
import utils.TestData;


import static com.codeborne.selenide.Selenide.sleep;



public class HwJavaFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal= new RegistrationResultModal();

        @Test
        @Tag("HomeWork")
        void practiceFormTest() {
            StudentData studentData = TestData.generateStudent();
            registrationPage
                    .openPage()
                    .removeBanner()
                    .setFirstName(studentData.getFirstName())
                    .setLastName(studentData.getLastName())
                    .setUserEmail(studentData.getUserEmail())
                    .setGender(studentData.getGender())
                    .setUserNumber(studentData.getUserPhone())
                    .setBirthday(studentData.getDay(), studentData.getMonth(), studentData.getYear())
                    .setSubject(studentData.getSubject())
                    .setHobbies(studentData.getHobby())
                    .setPicture(studentData.getFilePath())
                    .setCurrentAddress(studentData.getAddress())
                    .setState(studentData.getState())
                    .setCity(studentData.getCity())
                    .clickSubmit();

            registrationResultModal.verifyModalAppears()
                    .verifyResult("Student Name", studentData.getFirstName() + " " + studentData.getLastName())
                    .verifyResult("Student Email", studentData.getUserEmail())
                    .verifyResult("Gender", studentData.getGender())
                    .verifyResult("Mobile", studentData.getUserPhone())
                    .verifyResult("Date of Birth", studentData.getDay() + " " + studentData.getMonth() + "," + studentData.getYear() )
                    .verifyResult("Subjects", studentData.getSubject())
                    .verifyResult("Hobbies", studentData.getHobby())
                    .verifyResult("Picture", studentData.getFilePath())
                    .verifyResult("Address", studentData.getAddress())
                    .verifyResult("State and City", studentData.getState() + " " + studentData.getCity() );

        sleep(2000);
    }

}



