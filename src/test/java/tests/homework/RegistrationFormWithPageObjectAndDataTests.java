package tests.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageChecks;
import tests.data.TestData;

import static tests.data.TestData.*;

public class RegistrationFormWithPageObjectAndDataTests extends TestBase {

    static RegistrationPage registrationPage = new RegistrationPage();
    static RegistrationPageChecks registrationPageChecks = new RegistrationPageChecks();
    static TestData testData = new TestData();

    @BeforeEach
    void prepare() {
        testData.prepareTestData();
    }

    @Test
    void successfulRegistrationWithMaximumFieldsTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picturePath)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm();
        //Assert
        registrationPageChecks.checkResultPage(registrationPageChecks.title)
                .checkResultData(registrationPageChecks.studentName, firstName + " " + lastName)
                .checkResultData(registrationPageChecks.email, email)
                .checkResultData(registrationPageChecks.gender, gender)
                .checkResultData(registrationPageChecks.mobile, mobile)
                .checkResultData(registrationPageChecks.subjects, subject)
                .checkResultData(registrationPageChecks.hobbies, hobby)
                .checkResultData(registrationPageChecks.picture, "picture.PNG")
                .checkResultData(registrationPageChecks.address, currentAddress)
                .checkResultData(registrationPageChecks.dateOfBirth, day + " " + month + "," + year);
    }

    @Test
    void successfulRegistrationWithMinimumFieldsTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobile(mobile)
                .submitForm();
        //Assert
        registrationPageChecks.checkResultPage(registrationPageChecks.title)
                .checkResultData(registrationPageChecks.studentName, firstName + " " + lastName)
                .checkResultData(registrationPageChecks.mobile, mobile)
                .checkResultData(registrationPageChecks.gender, gender);
    }

    @Test
    void unsuccessfulRegistrationWithoutMobileTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .submitForm();
        //Assert
        registrationPageChecks.checkMobileIsRequired(registrationPage.mobileInput)
                .checkAbsenceOfModal();
    }
}