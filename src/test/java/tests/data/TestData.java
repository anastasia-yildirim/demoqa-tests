package tests.data;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public static String firstName,
            lastName,
            email,
            gender,
            mobile,
            day,
            month,
            year,
            subject,
            hobby,
            picturePath = "src/test/resources/img/picture.PNG",
            currentAddress,
            state,
            city;

    public static Faker faker = new Faker();

    public static void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        mobile = "8" + faker.number().numberBetween(111111111, 999999999);
        currentAddress = faker.address().streetAddress();
            //gender
        String[] genders = {"Male", "Female", "Other"};
        gender = faker.options().nextElement(genders);
            //birthdate: day
        int number = faker.number().numberBetween(1, 28);
        if (number < 10) {
            day = "0" + number;
        } else {
            day = number + "";
        }
            //birthdate: month and year
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        month = faker.options().nextElement(months);
        year = faker.number().numberBetween(1900, 2100) + "";
            //subjects
        List<String> subjects = Arrays.asList("English", "Maths", "Arts");
        subject = faker.options().nextElement(subjects);
            //hobbies
        String[] hobbies = {"Reading", "Sports", "Music"};
        hobby = faker.options().option(hobbies);
            //state
        String[] states = {"Haryana", "Rajasthan"};
        state = faker.options().option(states);
            //city
        String[] cities;
        if (state.equals("Haryana")) {
            cities = new String[]{"Karnal", "Panipat"};
        } else {
            cities = new String[]{"Jaipur", "Jaiselmer"};
        }
        city = faker.options().option(cities);
    }
}
