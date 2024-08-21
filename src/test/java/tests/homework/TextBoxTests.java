package tests.homework;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        //Act
        textBoxPage.openPage()
                .removeBanners()
                .setUserName("Lena")
                .setEmail("lena2384@email.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submitForm();
        //Assert
        textBoxPage.checkResultUserName("Lena")
                .checkResultEmail("lena2384@email.com")
                .checkResultCurrentAddress("Some street 1")
                .checkResultPermanentAddress("Another street 1");
    }
}
