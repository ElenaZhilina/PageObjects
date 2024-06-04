package ru.netology.data;

import lombok.Value;
import java.util.Random;

public class DataGen {
    private DataGen() {
    }

    @Value
    public static class User {
        String login;
        String pwd;
    }

    public static User getUser() {
        return new User("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getCode() {
        return new VerificationCode ("12345");
    }

    public static Card getFirstCard() {
        return new Card("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static Card getSecondCard() {
        return new Card("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static String maskedCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(12);
    }

    public static int validBalance(int balance) {
        return new Random().nextInt(Math.abs(balance)) + 1;
    }

    public static int invalidBalance(int balance) {
        return Math.abs(balance) + new Random().nextInt(10000);
    }

    @Value
    public static class Card {
        String cardNum;
        String testId;
    }
}