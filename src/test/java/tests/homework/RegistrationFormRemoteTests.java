package tests.homework;

import helpers.Attach;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import pages.RegistrationPageChecks;
import tests.data.TestData;

import static io.qameta.allure.Allure.step;

public class RegistrationFormRemoteTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageChecks registrationPageChecks = new RegistrationPageChecks();
    TestData testData = new TestData();

    @BeforeEach
    void prepare() {
        testData.prepareTestData();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Успешная регистрация с заполнением всех полей")
    void successfulRegistrationWithMaximumFieldsTest() {
        step("Открыть страницу", () -> {
                    registrationPage.openPage()
                            .removeBanners();
        });
        step("Заполнить форму", () -> {
            registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setMobile(testData.mobile)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picturePath)
                .setCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .submitForm();
        });
        step("Проверить корректность введенных данных", () -> {
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
        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Успешная регистрация с заполнением минимума полей")
    void successfulRegistrationWithMinimumFieldsTest() {
        step("Открыть страницу", () -> {
        registrationPage.openPage()
                .removeBanners();
        });
            step("Заполнить форму", () -> {
                    registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setMobile(testData.mobile)
                .submitForm();
            });
        step("Проверить корректность введенных данных", () -> {
        registrationPageChecks.checkResultPage(registrationPageChecks.title)
                .checkResultData(registrationPageChecks.studentName, testData.firstName + " " + testData.lastName)
                .checkResultData(registrationPageChecks.mobile, testData.mobile)
                .checkResultData(registrationPageChecks.gender, testData.gender);
        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Неуспешная регистрация - не заполнен телефон")
    void unsuccessfulRegistrationWithoutMobileTest() {
        step("Открыть страницу", () -> {
        registrationPage.openPage()
                .removeBanners();
        });
        step("Заполнить форму", () -> {
        registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .submitForm();
        });
        step("Убедиться, что регистрация не выполняется", () -> {
        registrationPageChecks.checkMobileIsRequired(registrationPage.mobileInput)
                .checkAbsenceOfModal();
        });
    }
}