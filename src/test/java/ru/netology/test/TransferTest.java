package ru.netology.test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGen;

public class TransferTest {

    @Test
    void moneyTransferToCard() {
        open("http://localhost:9999");

        var user = DataGen.getUser();
        $("[data-test-id=login] input").setValue(user.getLogin());
        $("[data-test-id=password] input").setValue(user.getPwd());
        $("[data-test-id=action-login]").click();
        $("[data-test-id=code] input").shouldBe(visible);



    }


}
