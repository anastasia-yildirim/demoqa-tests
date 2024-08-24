package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ModalOutputComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageChecks {

    private final SelenideElement modalOutput = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg");

    public final String title = "Thanks for submitting the form";
    public final String studentName = "Student Name";
    public final String email = "Student Email";
    public final String gender = "Gender";
    public final String mobile = "Mobile";
    public final String dateOfBirth = "Date of Birth";
    public final String subjects = "Subjects";
    public final String hobbies = "Hobbies";
    public final String picture = "Picture";
    public final String address = "Address";
    public final String stateAndCity = "State and City";

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