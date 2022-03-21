package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

    private WebDriver driver;
    private FluentWait fluentWait;

    @FindBy(id = "languages")
    WebElement languagesButton;

    @FindBy(id = "supplier")
    WebElement supplierButton;

    @FindBy(css = ".header-right .theme-btn-small:nth-of-type(1)")
    WebElement signupButton;

    @FindBy(css = ".header-right .theme-btn-small:nth-of-type(2)")
    WebElement loginButton;

    @FindBy(css = "ul[aria-labelledby='languages'] li:nth-of-type(1)")
    WebElement turkish;

    @FindBy(id="cookie_stop")
    WebElement cookiesBar;

    public BasePage(WebDriver driver, FluentWait fluentWait) {
        this.driver = driver;
        this.fluentWait = fluentWait;
        PageFactory.initElements(driver, this);
    }

    public void checkTurkish() {
        languagesButton.isDisplayed();
        languagesButton.click();
        turkish.isDisplayed();
    }

    public void goToLogin() {
        loginButton.isDisplayed();
        loginButton.click();
    }

    public void confirmCookies() {
        cookiesBar.click();
    }

    public void goToSignup() {
        signupButton.isDisplayed();
        signupButton.click();
    }
}
