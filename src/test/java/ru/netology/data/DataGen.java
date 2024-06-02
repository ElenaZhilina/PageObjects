package ru.netology.data;

import lombok.Value;

public class DataGen {
    private DataGen() {
    }

    @Value
    public static class User {
        private String login;
        private String pwd;
    }

    public static User getUser() {
        return new User("Helen", "qwerty1111");
    }

    public static User getOtherUser(User original) {
        return new User("Anrew", "1111qwerty");
    }

    @Value
    public static class Code {
        private String code;
    }

    public static Code getCodeFor(User userInfo) {
        return new Code("12345");
    }
}
