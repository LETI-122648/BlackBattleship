package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class MainPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.jetbrains.com/");

        // fechar cookies
        try {

            WebElement acceptCookies = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Accept All')]")
                    )
            );

            acceptCookies.click();

        } catch (Exception ignored) {
        }
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void search() {

        WebElement searchButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("[data-test='site-header-search-action']")
                )
        );

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", searchButton);

        WebElement searchField = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("input")
                )
        );

        searchField.sendKeys("Selenium");

        searchField.sendKeys(Keys.ENTER);

        wait.until(
                ExpectedConditions.urlContains("?s=")
        );

        assertTrue(
                driver.getCurrentUrl().contains("?s=")
        );
    }

    @Test
    public void toolsMenu() {

        WebElement productsButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Products')]")
                )
        );

        productsButton.click();

        WebElement popupMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("nav")
                )
        );

        assertTrue(popupMenu.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {

        driver.get("https://www.jetbrains.com/tools/");

        wait.until(
                ExpectedConditions.urlContains("/tools")
        );

        assertTrue(
                driver.getCurrentUrl().contains("/tools")
        );

        WebElement pageBody = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.tagName("body")
                )
        );

        assertTrue(pageBody.isDisplayed());
    }
}