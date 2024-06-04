package ru.netology.test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataGen.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGen;
import ru.netology.pages.DashboardPage;
import ru.netology.data.DataGen.Card;
import ru.netology.pages.LoginPage;

public class TransferTest {
    DashboardPage dashboardPage;
    Card firstCard;
    Card secondCard;
    int firstCardBalance;
    int secondCardBalance;

    @BeforeEach
    void setUp() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var userInfo = DataGen.getUser();
        var verificationPage = loginPage.validLogin(userInfo);
        var verificationCode = DataGen.getCode();
        dashboardPage = verificationPage.validVerify(verificationCode);
        firstCard = DataGen.getFirstCard();
        secondCard = DataGen.getSecondCard();
        firstCardBalance = dashboardPage.cardBalance(0);
        secondCardBalance = dashboardPage.cardBalance(maskedCardNumber(secondCard.getCardNum()));

    }

    @Test
    void successTransfer() {
        var sum = validBalance(firstCardBalance);
        var expectedFirstCard = firstCardBalance - sum;
        var expectedSecondCard = secondCardBalance + sum;
        var transferPage = dashboardPage.selectTrancferCard(secondCard);
        transferPage.toTransfer(String.valueOf(sum), firstCard);
        dashboardPage.reloadDashboardPage();
        var actualFirstCard = dashboardPage.cardBalance(0);
        var actualSecondCard = dashboardPage.cardBalance(maskedCardNumber(secondCard.getCardNum()));
        assertAll(() -> assertEquals(expectedFirstCard, actualFirstCard),
                () -> assertEquals(expectedSecondCard, actualSecondCard));
    }


}
