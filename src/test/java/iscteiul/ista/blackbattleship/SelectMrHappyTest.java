package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectMrHappyTest {

    @Test
    public void selectMrHappyTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://papergames.io/en/battleship");

        // cookies
        try {

            WebElement consentButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@aria-label='Consent']")
                    )
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", consentButton);

            Thread.sleep(2000);

        } catch (Exception ignored) {
        }

        // shop
        WebElement shopButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@href,'/shop')]")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", shopButton);

        Thread.sleep(2000);

        // monsters
        WebElement monstersButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//h3[contains(text(),'Monsters')]")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", monstersButton);

        Thread.sleep(3000);

        // botão do Mr Happy
        WebElement mrHappyButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//div[contains(text(),'Mr. Happy')]" +
                                        "/ancestor::div[contains(@class,'avatar')]" +
                                        "//button"
                        )
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", mrHappyButton);

        Thread.sleep(5000);

        driver.quit();
    }
}