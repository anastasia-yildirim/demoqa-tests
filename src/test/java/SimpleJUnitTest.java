import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void thirdTest() {
        Assertions.assertTrue(3 > 2);
    }
}
