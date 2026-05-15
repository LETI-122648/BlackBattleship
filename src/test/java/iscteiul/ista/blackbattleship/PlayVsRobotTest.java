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

public class PlayVsRobotTest {

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
    public void playVsRobotTest() throws InterruptedException {

        // carregar em "Play vs robot"
        WebElement robotButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Play vs robot')]")
                )
        );

        Thread.sleep(1000);

        robotButton.click();

        // esperar popup do nickname
        WebElement nicknameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[formcontrolname='username']")
                )
        );

        Thread.sleep(1000);

        // inserir nickname
        nicknameField.sendKeys("tester");

        Thread.sleep(1000);

        // carregar em continue
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

        // manter o jogo aberto durante 2 segundos
        Thread.sleep(2000);
    }
}