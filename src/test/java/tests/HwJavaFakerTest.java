package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static tests.TestData.*;
import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomItemFromArray;

public class HwJavaFakerTest extends TestBase {

    //https://demoqa.com/automation-practice-form

    @Test
    void practiceFormTest() {
        Faker faker = new Faker();

        String userName = faker.name().firstName(),
                lastName = faker.name().lastName() ,
                userEmail = faker.internet().emailAddress() ,
                userNumber = "8" + faker.phoneNumber().subscriberNumber(9),
                gender = getRandomItemFromArray(usergender) ,
                day = String.valueOf(getRandomInt(1, 30)),
                month = getRandomItemFromArray(usermonth),
                year = String.valueOf(getRandomInt(1900, 2100)),
                subject = getRandomItemFromArray(usersubject) ,
                hobbies = getRandomItemFromArray(userhobbies) ,
                picture = "--44.jpeg" ,
                currentAddress = faker.address().fullAddress() ,
                state = "Uttar Pradesh" ,
                city = getRandomItemFromArray(usercity);


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
                .setPicture()
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)

                .clickSubmit();

        registrationPage.verifyResult("Student Name", userName + " " + lastName)
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



