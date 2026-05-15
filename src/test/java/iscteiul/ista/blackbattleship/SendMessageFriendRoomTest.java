package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SendMessageFriendRoomTest {

    @Test
    public void sendMessageFriendRoomTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://papergames.io/en/battleship");

        // esperar página carregar
        Thread.sleep(5000);

        // aceitar cookies
        try {

            WebElement cookiesButton = driver.findElement(
                    By.xpath("//p[contains(text(),'Consent')]")
            );

            cookiesButton.click();

            Thread.sleep(1000);

        } catch (Exception ignored) {
        }

        // clicar Play with a friend
        WebElement playWithFriendButton = driver.findElement(
                By.xpath("//span[contains(text(),'Play with a friend')]")
        );

        playWithFriendButton.click();

        Thread.sleep(2000);

        // escrever nickname
        WebElement nicknameInput = driver.findElement(
                By.xpath("//input[@placeholder='Nickname']")
        );

        nicknameInput.sendKeys("Test");

        Thread.sleep(1000);

        // clicar Continue
        WebElement continueButton = driver.findElement(
                By.xpath("//button[contains(text(),'Continue')]")
        );

        continueButton.click();

        // esperar sala abrir
        Thread.sleep(5000);

        // clicar caixa de mensagem
        WebElement messageBox = driver.findElement(
                By.xpath("//textarea[contains(@placeholder,'Write a message')]")
        );

        messageBox.click();

        Thread.sleep(1000);

        // escrever mensagem
        messageBox.sendKeys("Olá amigo");

        Thread.sleep(2000);

        // clicar botão verde enviar
        WebElement sendButton = driver.findElement(
                By.cssSelector("button[type='submit']")
        );

        sendButton.click();

        // esperar para visualizar mensagem enviada
        Thread.sleep(5000);

        driver.quit();
    }
}