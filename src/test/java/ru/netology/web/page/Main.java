
package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Main {
    private SelenideElement debitButton = $$("[class='button button_size_m button_theme_alfa-on-white']").get(0);
    private SelenideElement creditButton = $("[class='button button_view_extra button_size_m button_theme_alfa-on-white']");

    public Payment buyDebitCard() {
        debitButton.click();
        return new Payment();
    }

    public Payment buyCreditCard() {
        creditButton.click();
        return new Payment();
    }
}