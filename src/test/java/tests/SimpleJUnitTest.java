package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    static int number;

    @BeforeAll
    static void beforeAll() {
        System.out.println("### beforeAll() \n");
    }

    @BeforeEach
    void beforeEach() {
        number = 3;
        System.out.println("###  beforeEach()");
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(number > 2);
        System.out.println("###     firstTest()");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(number > 2);
        System.out.println("###     secondTest()");
    }

    @Test
    void thirdTest() {
        Assertions.assertTrue(number > 2);
        System.out.println("###     thirdTest()");
    }

    @AfterEach
    void afterEach() {
        number = 0;
        System.out.println("###  afterEach() \n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("### afterAll()");
    }
}
