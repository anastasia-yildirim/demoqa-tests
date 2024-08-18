package tests.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void fillFormTest() {
        //Act
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Lena");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("lena2384@email.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day.react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/picture.PNG"));
        $("#currentAddress").setValue("Random street 1");
        //$(byText("State and City")).scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        //Assert
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("td").filterBy(text("Student Name")).first().sibling(0).shouldHave(text("Lena Petrova"));
        $$("td").filterBy(text("Student Email")).first().sibling(0).shouldHave(text("lena2384@email.com"));
        $$("td").filterBy(text("Mobile")).first().sibling(0).shouldHave(text("1234567890"));
        $$("td").filterBy(text("Date of Birth")).first().sibling(0).shouldHave(text("07 January,1999"));
        $$("td").filterBy(text("State and City")).first().sibling(0).shouldHave(text("NCR Delhi"));
    }
}
