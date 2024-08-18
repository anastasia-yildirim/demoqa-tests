package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalOutputComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit"),
            userNameOutput = $("#name"),
            emailOutput = $("#email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalOutputComponent modalOutputComponent = new ModalOutputComponent();

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void submitForm() {
        submitInput.click();
    }

    public TextBoxPage checkResultUserName(String value) {
        userNameOutput.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkResultEmail(String value) {
        emailOutput.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkResultCurrentAddress(String value) {
        currentAddressOutput.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkResultPermanentAddress(String value) {
        permanentAddressOutput.shouldHave(text(value));

        return this;
    }

}
