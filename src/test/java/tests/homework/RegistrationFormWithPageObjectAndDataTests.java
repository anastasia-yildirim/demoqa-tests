package tests.homework;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.data.TestData;

import static tests.data.TestData.*;

public class RegistrationFormWithPageObjectAndDataTests extends TestBase {

    static RegistrationPage registrationPage = new RegistrationPage();
    static TestData testData = new TestData();

   // testData.prepareTestData();

    @Test
    void successfulRegistrationWithMaximumFieldsTest() {
        //Act
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(picturePath)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm();
        //Assert
        registrationPage.checkResultPage("Thanks for submitting the form")
                .checkResultData("Student Name", firstName + " " + lastName)
                .checkResultData("Student Email", email)
                .checkResultData("Mobile", mobile)
                .checkResultData("Date of Birth", day + " " + month + "," + year)
                .checkResultData("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithMinimumFieldsTest() {
        //Act
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobile(mobile)
                .submitForm();
        //Assert
        registrationPage.checkResultPage("Thanks for submitting the form")
                .checkResultData("Student Name", firstName + " " + lastName)
                .checkResultData("Mobile", mobile)
                .checkResultData("Gender", gender);
    }

    @Test
    void unsuccessfulRegistrationWithoutMobileTest() {
        //Act
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .submitForm();
        //Assert
        registrationPage.checkUnsuccessfulValidation("Mobile");
    }
}
