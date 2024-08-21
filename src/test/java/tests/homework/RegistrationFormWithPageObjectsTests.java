package tests.homework;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageChecks;

public class RegistrationFormWithPageObjectsTests extends TestBase {

    static RegistrationPage registrationPage = new RegistrationPage();
    static RegistrationPageChecks registrationPageChecks = new RegistrationPageChecks();

    @Test
    void successfulRegistrationWithMaximumFieldsTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Lena")
                .setLastName("Petrova")
                .setEmail("lena2384@email.com")
                .setGender("Female")
                .setMobile("1234567890")
                .setDateOfBirth("07", "January", "1999")
                .setSubject("English")
                .setHobby("Reading")
                .uploadPicture("src/test/resources/img/picture.PNG")
                .setCurrentAddress("Random street 1")
                .setStateAndCity("NCR", "Delhi")
                .submitForm();
        //Assert
        registrationPageChecks.checkResultPage("Thanks for submitting the form")
                .checkResultData("Student Name", "Lena Petrova")
                .checkResultData("Student Email", "lena2384@email.com")
                .checkResultData("Mobile", "1234567890")
                .checkResultData("Date of Birth", "07 January,1999")
                .checkResultData("State and City", "NCR Delhi");
    }

    @Test
    void successfulRegistrationWithMinimumFieldsTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Anatoliy")
                .setLastName("Lisuha")
                .setGender("Male")
                .setMobile("0987654321")
                .submitForm();
        //Assert
        registrationPageChecks.checkResultPage("Thanks for submitting the form")
                .checkResultData("Student Name", "Anatoliy Lisuha")
                .checkResultData("Mobile", "0987654321")
                .checkResultData("Gender", "Male");
    }

    @Test
    void unsuccessfulRegistrationWithoutMobileTest() {
        //Act
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("X")
                .setLastName("Y")
                .setGender("Other")
                .submitForm();
        //Assert
        registrationPageChecks.checkMobileIsRequired("Mobile", registrationPage.mobileInput)
                .checkAbsenceOfModal();
    }
}
