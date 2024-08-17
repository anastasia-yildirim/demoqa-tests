package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        //Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // чтоб не дожидаться, пока вся страница загрузится (баннеры и т.д.)
        Configuration.timeout = 5000; //default = 4000
    }

    @Test
    void fillFormTest() {
        //Act
        open("/text-box");
        $("#userName").setValue("John Donn");
        $("#userEmail").setValue("john.donn2384@email.com");
        $("#currentAddress").setValue("Random street 1");
        $("#permanentAddress").setValue("New street 13");
        $("#submit").scrollIntoView(true).click();
        //Assert
        $("#output #name").shouldHave(text("John Donn"));
        $("#output #email").shouldHave(text("john.donn2384@email.com"));
        $("#output #currentAddress").shouldHave(text("Random street 1"));
        $("#output #permanentAddress").shouldHave(text("New street 13"));

    }
}
