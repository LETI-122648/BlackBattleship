package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AttackRobotTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://papergames.io/en/battleship");

        // aceitar cookies
        try {

            WebElement consentButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("button[aria-label='Consent']")
                    )
            );

            consentButton.click();

            Thread.sleep(2000);

        } catch (Exception ignored) {
        }
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void attackRobotTest() {

        // carregar em "Play vs robot"
        WebElement robotButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Play vs robot')]")
                )
        );

        robotButton.click();

        // esperar popup do nickname
        WebElement nicknameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[formcontrolname='username']")
                )
        );

        // inserir nickname
        nicknameField.sendKeys("tester");

        // carregar em continue
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[type='submit']")
                )
        );

        continueButton.click();

        // verificar entrada no jogo
        wait.until(
                ExpectedConditions.urlContains("/r/")
        );

        assertTrue(driver.getCurrentUrl().contains("/r/"));

        // esperar tabuleiro do adversário
        WebElement enemyBoard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("table.table-board")
                )
        );

        // obter células clicáveis
        List<WebElement> cells = enemyBoard.findElements(
                By.cssSelector("td")
        );

        // atacar primeira célula disponível
        cells.get(0).click();

        // verificar que o ataque aconteceu
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("svg.intersection")
                )
        );

        assertTrue(
                driver.findElements(
                        By.cssSelector("svg.intersection")
                ).size() > 0
        );
    }
}