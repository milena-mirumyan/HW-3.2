import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BenefitsPage extends BasePage {

    public WebElement contactLink = driver.findElement(By.cssSelector(Locators.contactLink));
    public BenefitsPage(WebDriver driver) {
        super(driver, Duration.ZERO);
    }

    public void navigateToBenefits() {
        driver.findElement(By.cssSelector(Locators.exploreBenefitsButton)).click();
    }
    public void clickContactLink() {
        contactLink.click();
    }

    public boolean isAt() {
        return driver.findElement(By.cssSelector(Locators.benefitsPage)).isDisplayed();
    }

}