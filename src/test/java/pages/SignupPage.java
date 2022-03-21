package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.JavascriptExecutor;

import utils.User;
import java.util.List;

public class SignupPage {

    WebDriver driver;
    FluentWait fluentWait;

    @FindBy(css = "input.form-control")
    List<WebElement> formInputs;
        // = driver.findElements(By.cssSelector("form-control"));

    @FindBy(className = "btn-lg")
    WebElement signup;

    public SignupPage(WebDriver driver, FluentWait fluentWait) {
        this.driver = driver;
        this.fluentWait = fluentWait;
        PageFactory.initElements(driver, this);
    }

    public void waitForElements() {
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(formInputs));
    }

    public void fillForm(User user) {
        formInputs.forEach(WebElement::isDisplayed);
        formInputs.get(0).sendKeys(user.getFirstName());
        formInputs.get(1).sendKeys(user.getLastName());
        formInputs.get(2).sendKeys(user.getPhone());
        formInputs.get(3).sendKeys(user.getEmail());
        formInputs.get(4).sendKeys(user.getPassword());
    }

    public void confirmSignup() throws InterruptedException {
        fluentWait.until(ExpectedConditions.elementToBeClickable(signup));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signup);
        Thread.sleep(500);
        signup.click();
    }
}
