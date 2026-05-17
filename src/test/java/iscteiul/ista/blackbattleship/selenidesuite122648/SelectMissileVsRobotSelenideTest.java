package iscteiul.ista.blackbattleship.selenidesuite122648;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectMissileVsRobotSelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void playVsRobotTest() {

        open("https://papergames.io/en/battleship");

        sleep(5000);

        // aceitar cookies
        $x("//p[contains(text(),'Consent')]")
                .click();

        sleep(1000);

        // clicar Play vs robot
        $x("//span[contains(text(),'Play vs robot')]")
                .click();

        sleep(2000);

        // inserir nickname
        $x("//input[@placeholder='Nickname']")
                .setValue("Test");

        sleep(1000);

        // clicar continue
        $x("//button[contains(text(),'Continue')]")
                .click();

        sleep(5000);

        // selecionar míssil
        $x("(//button[contains(@class,'weapon-button')])[2]")
                .click();

        sleep(3000);

        // validar entrada no jogo
        assertTrue(url().contains("/r/"));

        sleep(2000);

        closeWebDriver();
    }
}