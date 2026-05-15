package iscteiul.ista.blackbattleship.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//button[contains(@data-test,'search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Developer Tools')]")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//a[contains(@href,'/developer-tools/')]")
    public WebElement findYourToolsButton;

    @FindBy(xpath = "//button[contains(.,'Developer Tools')]")
    public WebElement toolsMenu;

    @FindBy(css = "button.fc-button.fc-cta-consent")
    public WebElement cookiesButton;

    @FindBy(css = "button[data-test='settings-button']")
    public WebElement settingsButton;

    @FindBy(css = "button[data-test='sound-button']")
    public WebElement soundButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}