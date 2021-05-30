package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Main {
    private static SelenideElement heading = $("[.heading_size_1]");
    private static SelenideElement cardPreview = $("[Order_cardPreview__47B2k]");

    public Main() {
        heading.shouldBe(visible).shouldHave(Condition.text("Путешествие дня"));
        cardPreview.shouldBe(visible).shouldHave(Condition.text("Марракэш"));
    }

}

