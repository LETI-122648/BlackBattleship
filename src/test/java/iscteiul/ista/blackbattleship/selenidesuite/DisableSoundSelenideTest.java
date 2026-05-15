package iscteiul.ista.blackbattleship.selenidesuite;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DisableSoundSelenideTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void disableSound() {

        open("https://papergames.io/en/battleship");

        sleep(3000);

        // aceitar cookies
        $$("button")
                .findBy(text("Consent"))
                .click();

        sleep(2000);

        // abrir definições
        $("button:has(svg[data-icon='gear'])").click();

        sleep(2000);

        // desligar som
        $$("mat-slide-toggle").first().click();

        sleep(2000);
    }
}