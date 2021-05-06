package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.BeforeEach;


public class ChangeDateTest {

    String name = DataGenerator.getNewName();
    String phone = DataGenerator.getNewPhoneNumber();
    String city = DataGenerator.getNewCity();
    //String date = DataGenerator.getNewDate();

    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
        //Faker = new Faker(new Locale("ru"));
        }

    @Test
    public void shouldAcceptInformation() {

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Город']").setValue(city);
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(DataGenerator.getNewDate(3));
        $("[name=name]").setValue(name);
        $("[name=phone]").setValue(phone);
        $(".checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно")).shouldBe(visible);
        $("input[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(DataGenerator.getNewDate(5));
        $(".button__text").click();
        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).waitUntil(visible, 15000);
        $("[data-test-id=replan-notification] button.button").click();
        $(withText("Успешно")).waitUntil(visible, 15000);

    }

}