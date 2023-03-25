package utils;

import com.github.javafaker.Faker;
import java.util.Map;


public class TestData {

    public static Faker faker = new Faker();

    public static String[] usergender = {"Male", "Female", "Other"};

    public static String[] usersubject = {"English", "Maths", "Arts", "Computer Science",
            "Economics", "Social Students", "History", "Civics", "Commerce", "Hindi", "Biology", "Accounting"};

    public static String[] userhobbies = {"Reading", "Sports", "Music"};

    public static String[] usermonth = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    public static StudentData generateStudent() {
        String firstName = faker.name().firstName(),
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
                state = faker.options().option(mapStateWithCity.keySet().toArray()).toString(),
                city = faker.options().option(mapStateWithCity.get(state));

        return new StudentData()
                .thisFirstName(firstName)
                .thisLastName(lastName)
                .thisUserEmail(userEmail)
                .thisGender(gender)
                .thisUserPhone(userNumber)
                .thisFilePath(picture)
                .thisAddress(currentAddress)
                .thisState(state)
                .thisCity(city)
                .thisSubject(subject)
                .thisHobby(hobbies)
                .thisDay(day)
                .thisMonth(month)
                .thisYear(year);

    }
}


