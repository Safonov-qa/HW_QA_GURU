package tests;

import com.github.javafaker.Faker;


public class TestData {

    static Faker faker = new Faker();

    public static String[] usergender = {"Male", "Female", "Other"};

    public static String[] usersubject = {"English", "Maths", "Arts", "Computer Science",
            "Economics", "Social Students", "History", "Civics", "Commerce", "Hindi", "Biology", "Accounting"};

    public static String[] userhobbies = {"Reading", "Sports", "Music"};

    public static String[] usercity = {"Delhi", "Gurgaon", "Noida"};

    public static String[] usermonth = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};




    public static String
            userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = "8" + faker.phoneNumber().subscriberNumber(9),
            gender = faker.options().option(usergender),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            month = faker.options().option(usermonth),
            year = String.valueOf(faker.number().numberBetween(1900, 2100)),
            subject = faker.options().option(usersubject),
            hobbies = faker.options().option(userhobbies),
            picture = "--44.jpeg",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = faker.options().option(usercity);

}


