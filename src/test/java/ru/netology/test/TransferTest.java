package ru.netology.test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class TransferTest {

    @Test
    void moneyTransferToCard() {
        open("http://localhost:9999");

    }


}
