package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQLdata;
import ru.netology.web.page.Payment;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditPayTest {
    Payment payment = new Payment();

    @BeforeEach
    void setUp() {
        SQLdata.cleanDataBase();
        open("http://localhost:8080");
        payment.buyCreditCard();
    }

    @BeforeAll
    static void SetUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldCreditPayFirstCardValidInfo() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.resultApproved();
        val expected = DataHelper.getStatusFirstCard();
        val actual = SQLdata.getPayStatusByCreditCard();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreditPaySecondCardValidInfo() {
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.resultApproved();
        val expected = DataHelper.getStatusSecondCard();
        val actual = SQLdata.getPayStatusByCreditCard();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreditPayInvalidCardNumber() {
        val cardNumber = DataHelper.getInvalidCardNumer();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test
    void shouldCreditPayNullCardNumber() {
        val cardNumber = DataHelper.getNullCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.errorMessage();
    }

    @Test
    void shouldCreditPayEmptyCardNumber() {
        val cardNumber = DataHelper.getEmptyCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test
    void shouldCreditPayGenerateCardNumber() {
        val cardNumber = DataHelper.getGenerateCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.errorMessage();
    }

    @Test
    void shouldCreditPayWithInvalidMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getInvalidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidDate();
    }

    @Test  //операция одобрена
    void shouldCreditPayWithNullMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getNullMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test // неверный формат
    void shouldCreditPayWithEmptyMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getEmptyMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.emptyField();
    }

    @Test
    void shouldCreditPayWithInvalidYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getInvalidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.expiredDateCard();
    }

    @Test
    void shouldCreditPayWithNullYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getNullYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.expiredDateCard();
    }

    @Test
    void shouldCreditPayWithEmptyYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getEmptyYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test
    void shouldCreditPayWithRandomName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getGenerateName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.resultApproved();
    }

    @Test
    void shouldCreditPayWithEmptyName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getEmptyName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.emptyField();
    }

    @Test  //операция одобрена
    void shouldCreditPayWithInvalidName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getInvalidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test  //операция одобрена
    void shouldCreditPayWithShortName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getShortName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test  // операция одобрена
    void shouldCreditPayWithNullCVC() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getNullCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }

    @Test
    void shouldCreditPayWithShortCVC() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getShortCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.invalidInfo();
    }
}
