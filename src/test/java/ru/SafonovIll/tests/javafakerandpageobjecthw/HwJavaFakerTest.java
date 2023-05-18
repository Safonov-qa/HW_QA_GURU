package ru.SafonovIll.tests.javafakerandpageobjecthw;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.SafonovIll.pages.RegistrationPage;
import ru.SafonovIll.pages.components.RegistrationResultModal;
import ru.SafonovIll.utils.StudentData;
import ru.SafonovIll.utils.TestData;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


@Tag("HomeWork")


public class HwJavaFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal= new RegistrationResultModal();

        @Test
        void practiceFormTest() {
            StudentData studentData = TestData.generateStudent();
            step("Open practice form", () -> {
            registrationPage
                    .openPage()
                    .removeBanner();
            });
            step("Fill form", () -> {
                        registrationPage
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
                    });
            step("Verify results ", () -> {

                        registrationResultModal.verifyModalAppears()
                                .verifyResult("Student Name", studentData.getFirstName() + " " + studentData.getLastName())
                                .verifyResult("Student Email", studentData.getUserEmail())
                                .verifyResult("Gender", studentData.getGender())
                                .verifyResult("Mobile", studentData.getUserPhone())
                                .verifyResult("Date of Birth", studentData.getDay() + " " + studentData.getMonth() + "," + studentData.getYear())
                                .verifyResult("Subjects", studentData.getSubject())
                                .verifyResult("Hobbies", studentData.getHobby())
                                .verifyResult("Picture", studentData.getFilePath())
                                .verifyResult("Address", studentData.getAddress())
                                .verifyResult("State and City", studentData.getState() + " " + studentData.getCity());
                    });

        sleep(2000);
    }

}



