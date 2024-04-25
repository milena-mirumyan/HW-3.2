import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FooterPage extends BasePage {

    // Constructor
    public FooterPage(WebDriver driver) {
        super(driver, Duration.ZERO);
    }

    // Method to click on the contact link in the footer
    public void clickContactLink() {
        driver.findElement(By.cssSelector(Locators.contactLink)).click();
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isAtFooter() {
        return driver.findElement(By.cssSelector(Locators.footer)).isDisplayed();
    }
}
