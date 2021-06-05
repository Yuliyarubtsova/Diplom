package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Payment {
    private SelenideElement heading = $$("[.button .button__text]").find(text("Кредит по данным карты"));
    private SelenideElement fieldNumberCard = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement fieldMonth = $("[placeholder='08']");
    private SelenideElement fieldYear = $("[placeholder='22']");
    private SelenideElement fieldOwner = $$("[class='input__control']").get(3);
    private SelenideElement fieldCVC = $("[placeholder='999']");
    private SelenideElement continueButton = $$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").get(1);
    private SelenideElement resultApproved = $(withText("Операция одобрена Банком"));
    private SelenideElement errorMessage = $(withText("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement invalidInfo = $(withText("Неверный формат"));
    private SelenideElement invalidDate = $(withText("Неверно указан срок действия карты"));
    private SelenideElement expiredDateCard = $(withText("Истёк срок действия карты"));
    private SelenideElement emptyField = $(withText("Поле обязательно для заполнения"));
    private SelenideElement invalidOwner = $(withText("Неверно указан владелец"));


    public void fieldInfo(String cardNumber, String month, String year, String owner, String cvc) {
        clearFields();
        fieldNumberCard.setValue(cardNumber);
        fieldMonth.setValue(month);
        fieldYear.setValue(year);
        fieldOwner.setValue(owner);
        fieldCVC.setValue(cvc);
        continueButton.click();
    }

    public void resultApproved() {
        resultApproved.shouldBe(visible, Duration.ofSeconds(16));
    }

    public void errorMessage() {
        errorMessage.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void invalidInfo() {
        invalidInfo.shouldBe(visible);
    }

    public void invalidDate() {
        invalidDate.shouldBe(visible);
    }

    public void expiredDateCard() {
        expiredDateCard.shouldBe(visible);
    }

    public void emptyField() {
        emptyField.shouldBe(visible);
    }

    public void invalidOwner() {
        invalidOwner.shouldBe(visible);
    }

    public Payment clearFields() {
        clear();
        return new Payment();
    }

    public void clear() {
        fieldNumberCard.sendKeys(Keys.chord(Keys.CONTROL + "A" + Keys.DELETE));
        fieldMonth.sendKeys(Keys.chord(Keys.CONTROL + "A" + Keys.DELETE));
        fieldYear.sendKeys(Keys.chord(Keys.CONTROL + "A" + Keys.DELETE));
        fieldOwner.sendKeys(Keys.chord(Keys.CONTROL + "A" + Keys.DELETE));
        fieldCVC.sendKeys(Keys.chord(Keys.CONTROL + "A" + Keys.DELETE));
    }
}