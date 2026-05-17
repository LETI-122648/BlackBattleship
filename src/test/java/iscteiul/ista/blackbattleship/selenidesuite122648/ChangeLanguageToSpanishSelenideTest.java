package iscteiul.ista.blackbattleship.selenidesuite122648;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeLanguageToSpanishSelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void changeLanguageToSpanishTest() {

        open("https://papergames.io/pt-br/batalha-naval");

        sleep(3000);

        // aceitar cookies
        $x("//p[contains(text(),'Consent')]")
                .click();

        sleep(3000);

        // abrir settings
        $x("//button[contains(@class,'mat-mdc-icon-button')]")
                .click();

        sleep(2000);

        // clicar idioma
        $x("//label[contains(text(),'Idioma')]")
                .click();

        sleep(2000);

        // escolher espanhol
        $x("//span[contains(text(),'Español')]")
                .click();

        sleep(2000);

        // validar alteração
        assertTrue(source().contains("Batalla Naval"));

        sleep(2000);

        closeWebDriver();
    }
}