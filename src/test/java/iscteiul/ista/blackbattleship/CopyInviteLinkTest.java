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

public class CopyInviteLinkTest {

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

            // popup pode não aparecer
        }
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void copyInviteLinkTest() throws InterruptedException {

        // clicar em "Play with a friend"
        WebElement playWithFriendButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[contains(text(),'Play with a friend')]")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", playWithFriendButton);

        // esperar popup do nickname
        WebElement nicknameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[formcontrolname='username']")
                )
        );

        // escrever nickname
        nicknameInput.sendKeys("tester");

        Thread.sleep(1000);

        // clicar continue
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[type='submit']")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", continueButton);

        // esperar página da sala carregar
        wait.until(
                ExpectedConditions.urlContains("/r/")
        );

        // esperar botão/link de copiar aparecer
        WebElement copyLinkButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div[mattooltip='Click to copy']")
                )
        );

        // clicar para copiar
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", copyLinkButton);

        Thread.sleep(1500);

        // verificar mensagem de sucesso
        WebElement copiedMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Copied to clipboard')]")
                )
        );

        assertTrue(copiedMessage.isDisplayed());
    }
}