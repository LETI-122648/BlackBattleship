package iscteiul.ista.blackbattleship;

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

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}