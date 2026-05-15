package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

            Thread.sleep(1000);

        } catch (Exception ignored) {
        }
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void attackRobotTest() throws InterruptedException {

        // carregar em "Play vs robot"
        WebElement robotButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Play vs robot')]")
                )
        );

        Thread.sleep(1000);

        robotButton.click();

        // esperar popup nickname
        WebElement nicknameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[formcontrolname='username']")
                )
        );

        Thread.sleep(1000);

        // inserir nickname
        nicknameField.sendKeys("tester");

        Thread.sleep(1000);

        // carregar continue
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[type='submit']")
                )
        );

        Thread.sleep(1000);

        continueButton.click();

        // verificar entrada no jogo
        wait.until(
                ExpectedConditions.urlContains("/r/")
        );

        assertTrue(driver.getCurrentUrl().contains("/r/"));

        // esperar tabuleiro carregar
        WebElement enemyBoard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.opponent table.table-board")
                )
        );

        // esperar turno
        Thread.sleep(5000);

        // obter células do tabuleiro inimigo
        List<WebElement> cells = enemyBoard.findElements(By.cssSelector("td"));

        boolean attacked = false;

        // procurar primeira célula clicável
        for (WebElement cell : cells) {

            try {

                Thread.sleep(200);

                // clicar na célula
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", cell);

                Thread.sleep(1000);

                // verificar se apareceu ataque
                if (cell.findElements(By.cssSelector("svg.intersection")).size() > 0) {

                    attacked = true;
                    break;
                }

            } catch (Exception ignored) {
            }
        }

        // validar que houve ataque real
        assertTrue(attacked);

        // deixar jogo aberto no final
        Thread.sleep(2000);
    }
}