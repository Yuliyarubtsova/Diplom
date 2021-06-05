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
import ru.netology.web.page.Main;
import ru.netology.web.page.Payment;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitPayTest {
    Payment payment = new Payment();
    Main main = new Main();

    @BeforeEach
    void setUp() {
        SQLdata.cleanDataBase();
        open("http://localhost:8080");
        main.buyDebitCard();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldDebitPayFirstCardValidInfo() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.resultApproved();
        val expected = DataHelper.getStatusFirstCard();
        val actual = SQLdata.getPayStatusByDebitCard();
        assertEquals(expected, actual);
    }

    @Test
    void shouldDebitPaySecondCardValidInfo() {
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitErrorMessage();
        val expected = DataHelper.getStatusSecondCard();
        val actual = SQLdata.getPayStatusByDebitCard();
        assertEquals(expected, actual);
    }

    @Test
    void shouldDebitPayInvalidCardNumber() {
        val cardNumber = DataHelper.getInvalidCardNumer();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }

    @Test
    void shouldDebitPayNullCardNumber() {
        val cardNumber = DataHelper.getNullCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitErrorMessage();
    }

    @Test
    void shouldDebitPayEmptyCardNumber() {
        val cardNumber = DataHelper.getEmptyCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }

    @Test
    void shouldDebitPayGenerateCardNumber() {
        val cardNumber = DataHelper.getGenerateCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitErrorMessage();
    }

    @Test
    void shouldDebitPayWithInvalidMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getInvalidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidDate();
    }

    @Test  //операция одобрена
    void shouldDebitPayWithNullMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getNullMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }

    @Test // неверный формат
    void shouldDebitPayWithEmptyMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getEmptyMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageEmptyField();
    }

    @Test
    void shouldDebitPayWithInvalidYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getInvalidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageExpiredDate();
    }

    @Test
    void shouldDebitPayWithNullYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getNullYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageExpiredDate();
    }

    @Test
    void shouldDebitPayWithEmptyYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getEmptyYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }

    @Test
    void shouldDebitPayWithRandomName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getGenerateName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.resultApproved();
    }

    @Test
    void shouldDebitPayWithEmptyName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getEmptyName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageEmptyField();
    }

    @Test  //операция одобрена
    void shouldDebitPayWithInvalidName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getInvalidName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessaegInvalidOwner();
    }

    @Test  //операция одобрена
    void shouldDebitPayWithShortName() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getShortName();
        val cvc = DataHelper.getValidCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }

    @Test  // операция одобрена
    void shouldDebitPayWithNullCVC() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getNullCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }

    @Test
    void shouldDebitPayWithShortCVC() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidName();
        val cvc = DataHelper.getShortCVC();
        payment.fieldInfo(cardNumber, month, year, owner, cvc);
        payment.waitMessageInvalidInfo();
    }
}
