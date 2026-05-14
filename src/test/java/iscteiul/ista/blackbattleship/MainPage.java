package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    @FindBy(linkText = "Products")
    public WebElement productsMenu;

    @FindBy(xpath = "//a[contains(@href,'/tools')]")
    public WebElement allProductsButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}