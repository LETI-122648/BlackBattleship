package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectMissileVsRobot {

    @Test
    public void playVsRobot() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://papergames.io/en/battleship");



        // esperar cookies
        Thread.sleep(5000);

        // aceitar cookies
        WebElement cookiesButton = driver.findElement(
                By.xpath("//p[contains(text(),'Consent')]")
        );

        cookiesButton.click();

        Thread.sleep(1000);



        // clicar Play vs robot
        WebElement playVsRobotButton = driver.findElement(
                By.xpath("//span[contains(text(),'Play vs robot')]")
        );

        playVsRobotButton.click();

        Thread.sleep(2000);



        // inserir nickname
        WebElement nicknameInput = driver.findElement(
                By.xpath("//input[@placeholder='Nickname']")
        );

        nicknameInput.sendKeys("Test");

        Thread.sleep(1000);



        // clicar continue
        WebElement continueButton = driver.findElement(
                By.xpath("//button[contains(text(),'Continue')]")
        );

        continueButton.click();

        Thread.sleep(5000);



        // selecionar míssil
        WebElement missileButton = driver.findElement(
                By.xpath("(//button[contains(@class,'weapon-button')])[2]")
        );

        missileButton.click();

        Thread.sleep(3000);



        // validar que entrou no jogo
        assertTrue(
                driver.getCurrentUrl().contains("/r/")
        );



        driver.quit();
    }
}