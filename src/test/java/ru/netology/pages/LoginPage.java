package ru.netology.pages;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGen;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataGen.User info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPwd());
        loginButton.click();
        return new VerificationPage();
    }
}