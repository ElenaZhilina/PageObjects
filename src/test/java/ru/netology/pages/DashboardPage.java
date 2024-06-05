package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataGen;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р. ";
    private final SelenideElement reloadButton = $("[data-test-id=action-reload]");
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public int cardBalance(String maskedCardNumber) {
        var text = cards.findBy(Condition.text(maskedCardNumber)).text();
        return extractBalance(text);
    }

    //public int cardBalance(int index) {
    //    var text = cards.get(index).getText();
    //    return extractBalance(text);
    //}

    public TransferPage selectTransferCard(DataGen.Card card) {
        cards.findBy(Condition.attribute("data-test-id", card.getTestId())).$(".button ").click();
        return new TransferPage();
    }

    public void reloadDashboardPage() {
        reloadButton.click();
        heading.shouldBe(visible);
    }

    private int extractBalance(String text) {
        System.out.println(text.indexOf(balanceStart));
        System.out.println(text.indexOf(balanceFinish));
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        //System.out.println(text.substring(start + balanceStart.length(), finish));
        return Integer.parseInt(value);
    }
}