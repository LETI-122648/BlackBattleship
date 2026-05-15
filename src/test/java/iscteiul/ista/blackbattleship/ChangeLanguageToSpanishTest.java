package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeLanguageToSpanishTest {

    @Test
    public void changeLanguageToSpanish() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://papergames.io/pt-br/batalha-naval");



        // aceitar cookies
        WebElement cookiesButton = driver.findElement(
                By.xpath("//p[contains(text(),'Consent')]")
        );

        cookiesButton.click();

        Thread.sleep(3000);



        // abrir settings
        WebElement settingsButton = driver.findElement(
                By.xpath("//button[contains(@class,'mat-mdc-icon-button')]")
        );

        settingsButton.click();

        Thread.sleep(1000);



        // clicar idioma
        WebElement languageButton = driver.findElement(
                By.xpath("//label[contains(text(),'Idioma')]")
        );

        languageButton.click();

        Thread.sleep(1000);



        // escolher espanhol
        WebElement spanishButton = driver.findElement(
                By.xpath("//span[contains(text(),'Español')]")
        );

        spanishButton.click();

        Thread.sleep(1500);



        // validação
        assertTrue(
                driver.getPageSource().contains("Batalla Naval")
        );



        driver.quit();
    }
}