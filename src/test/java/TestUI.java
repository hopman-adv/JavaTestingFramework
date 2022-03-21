import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.SignupPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.User;

import java.time.Duration;


public class TestUI {
    private static Logger LOGGER = LoggerFactory.getLogger(TestUI.class);

    WebDriver driver;
    FluentWait fluentWait;
    String BASE_URL = "https://www.phptravels.net";
    String driverPath = "/Users/jakub/Programování/JavaTestingFramework/src/main/resources/chromedriver";

    SignupPage signupPage;
    BasePage basePage;
    User user;

    @BeforeEach
    public void setupTesting() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver= new ChromeDriver();
        fluentWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        signupPage = new SignupPage(driver, fluentWait);
        basePage = new BasePage(driver, fluentWait);

        user = new User();
        System.out.println("Jméno uživatele: "+user.getFirstName());
        System.out.println("Email: "+user.getEmail());
        System.out.println("Heslo: "+user.getPassword());

        driver.get(BASE_URL);
    }

    @Test
    public void checkLanguage() {
        basePage.checkTurkish();
    }

    @Test
    public void signin() throws InterruptedException {
        basePage.confirmCookies();
        basePage.goToSignup();
        signupPage.waitForElements();
        signupPage.fillForm(user);
        signupPage.confirmSignup();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
