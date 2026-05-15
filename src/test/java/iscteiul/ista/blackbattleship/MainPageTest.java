package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jetbrains.com/");

        try {

            WebElement acceptCookies = driver.findElement(
                    By.xpath("//button[contains(text(),'Accept All')]")
            );

            acceptCookies.click();

        } catch (Exception e) {

            System.out.println("Cookie popup not found");
        }

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void search() {

        driver.get("https://www.jetbrains.com/search/?q=Selenium");

        assertTrue(
                driver.getCurrentUrl().contains("Selenium")
        );
    }

    @Test
    public void toolsMenu() {

        driver.get("https://www.jetbrains.com/developer-tools/");

        assertTrue(
                driver.getCurrentUrl().contains("developer-tools")
        );
    }

    @Test
    public void navigationToAllTools() {

        driver.get("https://www.jetbrains.com/all/");

        assertTrue(
                driver.getCurrentUrl().contains("/all/")
        );

        assertTrue(
                driver.getTitle().contains("JetBrains")
        );
    }
}