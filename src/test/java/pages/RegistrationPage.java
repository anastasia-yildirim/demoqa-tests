package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public final SelenideElement mobileInput = $("#userNumber");
    private final SelenideElement firstNameInput = $("#firstName"), lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"), currentAddressInput = $("#currentAddress"),
            genderInput = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"), subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"), uploadPictureInput = $("#uploadPicture"),
            stateCityInput = $("#stateCity-wrapper"), stateInput = $("#state"),
            cityInput = $("#city"), submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setMobile(String value) {
        mobileInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureInput.uploadFile(new File(value));

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        stateCityInput.$(byText(state)).click();
        cityInput.click();
        stateCityInput.$(byText(city)).click();

        return this;
    }

    public void submitForm() {
        submitInput.click();
    }
}