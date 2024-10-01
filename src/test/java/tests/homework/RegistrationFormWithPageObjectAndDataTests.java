package tests.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageChecks;
import tests.data.TestData;

public class RegistrationFormWithPageObjectAndDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageChecks registrationPageChecks = new RegistrationPageChecks();
    TestData testData = new TestData();

    @BeforeEach
    void prepare() {
        testData.prepareTestData();
    }

    @Test
    void successfulRegistrationWithMaximumFieldsTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setMobile(testData.mobile)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picturePath)
                .setCurrentAddress(testData.currentAddress)
                .scrollToSubmitButton()
                .setStateAndCity(testData.state, testData.city)
                .submitForm();
        //Assert
        registrationPageChecks.checkResultPage(registrationPageChecks.title)
                .checkResultData(registrationPageChecks.studentName, testData.firstName + " " + testData.lastName)
                .checkResultData(registrationPageChecks.email, testData.email)
                .checkResultData(registrationPageChecks.gender, testData.gender)
                .checkResultData(registrationPageChecks.mobile, testData.mobile)
                .checkResultData(registrationPageChecks.subjects, testData.subject)
                .checkResultData(registrationPageChecks.hobbies, testData.hobby)
                .checkResultData(registrationPageChecks.picture, "picture.PNG")
                .checkResultData(registrationPageChecks.address, testData.currentAddress)
                .checkResultData(registrationPageChecks.dateOfBirth, testData.day + " " + testData.month + "," + testData.year);
    }

    @Test
    void successfulRegistrationWithMinimumFieldsTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setMobile(testData.mobile)
                .scrollToSubmitButton()
                .submitForm();
        //Assert
        registrationPageChecks.checkResultPage(registrationPageChecks.title)
                .checkResultData(registrationPageChecks.studentName, testData.firstName + " " + testData.lastName)
                .checkResultData(registrationPageChecks.mobile, testData.mobile)
                .checkResultData(registrationPageChecks.gender, testData.gender);
    }

    @Test
    void unsuccessfulRegistrationWithoutMobileTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .scrollToSubmitButton()
                .submitForm();
        //Assert
        registrationPageChecks.checkMobileIsRequired(registrationPage.mobileInput)
                .checkAbsenceOfModal();
    }
}