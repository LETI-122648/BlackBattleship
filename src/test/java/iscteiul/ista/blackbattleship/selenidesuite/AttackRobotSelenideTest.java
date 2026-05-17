package iscteiul.ista.blackbattleship.selenidesuite;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttackRobotSelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void attackRobotTest() {

        open("https://papergames.io/en/battleship");

        sleep(3000);

        // aceitar cookies
        $$("button")
                .findBy(text("Consent"))
                .click();

        sleep(2000);

        // carregar em "Play vs robot"
        $$("span")
                .findBy(text("Play vs robot"))
                .click();

        sleep(2000);

        // inserir nickname
        $("input[formcontrolname='username']")
                .setValue("tester");

        sleep(1000);

        // carregar continue
        $("button[type='submit']")
                .click();

        sleep(5000);

        // verificar entrada no jogo
        assertTrue(WebDriverRunner.url().contains("/r/"));

        // obter células do tabuleiro inimigo
        ElementsCollection cells =
                $$("div.opponent table.table-board td");

        // selecionar primeira célula
        SelenideElement firstCell = cells.get(0);

        sleep(1000);

        // realizar ataque
        firstCell.click();

        sleep(3000);

        // validar que o jogo continua aberto após o ataque
        assertTrue(WebDriverRunner.url().contains("/r/"));

        sleep(2000);
    }
}