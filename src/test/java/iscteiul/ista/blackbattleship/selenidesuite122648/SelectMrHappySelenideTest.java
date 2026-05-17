package iscteiul.ista.blackbattleship.selenidesuite122648;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectMrHappySelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void selectMrHappyTest() {

        open("https://papergames.io/en/battleship");

        sleep(5000);

        // aceitar cookies
        try {

            $x("//button[@aria-label='Consent']")
                    .click();

            sleep(2000);

        } catch (Exception ignored) {
        }

        // abrir shop
        $x("//a[contains(@href,'/shop')]")
                .click();

        sleep(4000);

        // popup pode aparecer aqui
        // se aparecer, fecha manualmente

        // abrir categoria monsters
        $x("//h3[contains(text(),'Monsters')]")
                .click();

        sleep(3000);

        // selecionar Mr Happy
        executeJavaScript(
                "arguments[0].click();",
                $x("//div[contains(text(),'Mr. Happy')]/ancestor::div[contains(@class,'avatar')]//button")
        );

        sleep(4000);

        // validar que continua na shop
        assertTrue(url().contains("shop"));

        sleep(3000);

        closeWebDriver();
    }
}