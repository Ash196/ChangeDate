package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    public DataGenerator() {
    }
    private static Faker faker = new Faker(new Locale("ru"));

    public static String getNewName() {
        return faker.name().fullName();
    }

    public static String getNewPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getNewCity() {
        return faker.address().city();
    }
    private static LocalDate today = LocalDate.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static String getNewDate(int plusDays) {
        LocalDate newDate = today.plusDays(plusDays);
        return formatter.format(newDate);
    }
}