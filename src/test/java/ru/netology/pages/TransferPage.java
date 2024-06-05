package ru.netology.pages;

import ru.netology.data.DataGen;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    public TransferPage() {
        $(byText("Пополнение карты")).shouldBe(visible);
    }

    public DashboardPage transfer(String sum, DataGen.Card card) {
        toTransfer(sum, card);
        return new DashboardPage();
    }

    public void toTransfer(String sum, DataGen.Card card) {
        $("[data-test-id=amount] input").setValue(sum);
        $("[data-test-id=from] input").setValue(card.getCardNum());
        $("[data-test-id=action-transfer]").click();
    }

    public void errorMsg(String msg) {
        $("[data-test-id=error-notification] .notification")
                .shouldHave(text(msg), Duration.ofSeconds(10))
                .shouldBe(visible);
    }
}
