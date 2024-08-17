package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpath() {

        //пример 1, скопировать
        $("[data-testid=email").setValue("1");
        $(by("data-testid", "email")).setValue("1");// другой вариант записи
        $x("//*[@data-testid='email']").setValue("1"); // XPath

        //пример 2, скопировать (если нет data-testid)
        $("[id=email").setValue("1");
        $(by("id", "email")).setValue("1"); // другой вариант записи
        $(byId("email")).setValue("1"); // другой вариант записи
        $("email").setValue("1"); // the best вариант записи
        $x("//*[@id='email']").setValue("1"); // XPath

        //пример 3, если нет id
        $("[name=email").setValue("1");
        $(by("name", "email")).setValue("1"); // другой вариант записи
        $(byName("email")).setValue("1"); // другой вариант записи
        $x("//*[@name='email']").setValue("1"); // XPath

        //пример 4, если нет name
        $("[class=inputtext][class=login_form_input_box]").setValue("1"); // указываем оба класса (внутри 1 элемента)
        $("[class=.inputtext.login_form_input_box]").setValue("1"); // указываем оба класса
        $("[class=.login_form_input_box]").setValue("1"); // the best
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1"); // XPath

        //пример 5, с дивом
        $("[class=.inputtext .login_form_input_box]").setValue("1"); // указываем оба элемента
        $(".inputtext").$(".login_form_input_box").setValue("1");
        $("div.inputtext").$("input.login_form_input_box").setValue("1"); // указали типы элементов
        $("div.inputtext input.login_form_input_box").setValue("1"); // указали типы элементов через пробел

        //поиск по тексту
        $(byText("Hello, qa.guru!"));
        $(withText("llo, qa.g"));
        $x("//*[text()='Hello, qa.guru!']"); //моветон
        $x("//*[contains(text(),'Hello, qa.guru!')]"); //норм вариант


        $(by("name", "email")).setValue("1"); // другой вариант записи
        $(byName("email")).setValue("1"); // другой вариант записи
        $x("//*[@name='email']").setValue("1"); // XPath
    }
}
