package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // чтоб не дожидаться, пока вся страница загрузится (баннеры и т.д.)
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default = 4000
    }

    @Test
    void fillFormTest() {
        //Act
        open("/automation-practice-form");
        $("#firstName").setValue("Lena");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("lena2384@email.com");
        $("#gender-radio-2").click();
        //$("#gender-radio-2").selectRadio("#gender-radio-2");
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").
        //TODO: subjects
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").selectOption("#hobbies-checkbox-1", "#hobbies-checkbox-2");
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/tests/resources/picture.png"));
        $("#currentAddress").setValue("Random street 1");
        $(". css-luccc91-singleValue").setValue("NCR");
        $(". css-luccc91-singleValue").setValue("Delhi");
        $("#submit").click();
        //Assert
        //TODO: check modal
        $("#output #name").shouldHave(text("John Donn"));
        $("#output #email").shouldHave(text("john.donn2384@email.com"));
        $("#output #currentAddress").shouldHave(text("Random street 1"));
        $("#output #permanentAddress").shouldHave(text("New street 13"));

    }
}
