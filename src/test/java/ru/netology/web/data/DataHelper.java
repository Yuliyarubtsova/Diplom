package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("ru"));

    private DataHelper() {
    }

    public static String getFirstCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getSecondCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getStatusFirstCard() {
        return "APPROVED";
    }

    public static String getStatusSecondCard() {
        return "DECLINED";
    }

    public static String getInvalidCardNumer() {
        return "1111";
    }

    public static String getNullCardNumber() {
        return "0000 0000 0000 0000";
    }

    public static String getEmptyCardNumber() {
        return "";
    }

    public static String getGenerateCardNumber() {
        return faker.business().creditCardNumber();
    }

    public static String getValidMonth() {
        return "09";
    }

    public static String getInvalidMonth() {
        return "15";
    }

    public static String getNullMonth() {
        return "00";
    }

    public static String getEmptyMonth() {
        return "";
    }

    public static String getValidYear() {
        return "25";
    }

    public static String getInvalidYear() {
        return "20";
    }

    public static String getNullYear() {
        return "00";
    }

    public static String getEmptyYear() {
        return "";
    }

    public static String getValidName() {
        return "Иванов Иван";
    }

    public static String getGenerateName() {
        return faker.name().fullName();
    }

    public static String getEmptyName() {
        return "";
    }

    public static String getInvalidName() {
        return "12Иванов Иван21";
    }

    public static String getShortName() {
        return "А";
    }

    public static String getValidCVC() {
        return "123";
    }

    public static String getNullCVC() {
        return "000";
    }

    public static String getShortCVC() {
        return "12";
    }













}
