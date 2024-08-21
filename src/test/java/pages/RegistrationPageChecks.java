package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ModalOutputComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageChecks {

    private final SelenideElement modalOutput = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg");

    ModalOutputComponent modalOutputComponent = new ModalOutputComponent();

    public RegistrationPageChecks checkResultPage(String value) {
        modalOutput.should(appear);
        modalTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPageChecks checkResultData(String key, String value) {
        modalOutputComponent.checkResultData(key, value);

        return this;
    }

    public RegistrationPageChecks checkMobileIsRequired(SelenideElement mobileInput) {

        mobileInput.shouldHave(attribute("required"));


        return this;
    }

    public void checkAbsenceOfModal() {
        modalOutput.shouldNot(appear);
    }
}