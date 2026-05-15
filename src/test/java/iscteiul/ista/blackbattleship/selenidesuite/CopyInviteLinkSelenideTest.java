package iscteiul.ista.blackbattleship.selenidesuite;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CopyInviteLinkSelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void copyInviteLinkTest() {

        open("https://papergames.io/en/battleship");

        sleep(3000);

        // aceitar cookies
        $$("button")
                .findBy(text("Consent"))
                .click();

        sleep(2000);

        // clicar em "Play with a friend"
        $$("span")
                .findBy(text("Play with a friend"))
                .click();

        sleep(2000);

        // inserir nickname
        $("input[formcontrolname='username']")
                .setValue("tester");

        sleep(1000);

        // clicar continue
        $("button[type='submit']")
                .click();

        sleep(5000);

        // verificar entrada na sala
        assertTrue(WebDriverRunner.url().contains("/r/"));

        // clicar no botão de copiar link
        $("div[mattooltip='Click to copy']")
                .shouldBe(visible)
                .click();

        sleep(2000);

        // verificar mensagem de sucesso
        $$("*")
                .findBy(text("Copied to clipboard"))
                .shouldBe(visible);

        sleep(2000);
    }
}