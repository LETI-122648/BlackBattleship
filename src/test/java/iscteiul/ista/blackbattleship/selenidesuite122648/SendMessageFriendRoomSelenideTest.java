package iscteiul.ista.blackbattleship.selenidesuite122648;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SendMessageFriendRoomSelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void sendMessageFriendRoomTest() {

        open("https://papergames.io/en/battleship");

        // esperar página carregar
        sleep(5000);

        // aceitar cookies
        try {

            $x("//p[contains(text(),'Consent')]")
                    .click();

            sleep(1000);

        } catch (Exception ignored) {
        }

        // clicar Play with a friend
        $x("//span[contains(text(),'Play with a friend')]")
                .click();

        sleep(2000);

        // escrever nickname
        $x("//input[@placeholder='Nickname']")
                .setValue("Test");

        sleep(1000);

        // clicar Continue
        $x("//button[contains(text(),'Continue')]")
                .click();

        // esperar sala abrir
        sleep(5000);

        // clicar caixa de mensagem
        $x("//textarea[contains(@placeholder,'Write a message')]")
                .click();

        sleep(1000);

        // escrever mensagem
        $x("//textarea[contains(@placeholder,'Write a message')]")
                .setValue("Olá amigo");

        sleep(2000);

        // clicar botão enviar
        $("button[type='submit']")
                .click();

        // esperar para visualizar mensagem enviada
        sleep(5000);

        closeWebDriver();
    }
}