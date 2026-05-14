package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DisableSoundTest {

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
    public void disableSoundTest() throws InterruptedException {

        // abrir settings
        WebElement settingsButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("button[mattooltip='Settings']")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", settingsButton);

        Thread.sleep(1500);

        // localizar botão real do switch
        WebElement soundButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#settings-sound button[role='switch']")
                )
        );

        // guardar estado inicial
        String initialState =
                soundButton.getAttribute("aria-checked");

        // clicar para desligar som
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", soundButton);

        // esperar mudança de estado
        wait.until(driver -> {

            String currentState =
                    soundButton.getAttribute("aria-checked");

            return currentState != null &&
                    !currentState.equals(initialState);
        });

        // verificar estado final
        String finalState =
                soundButton.getAttribute("aria-checked");

        assertNotEquals(initialState, finalState);
    }
}