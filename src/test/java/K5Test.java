import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class K5Test {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("chromdriver.chrome.driver", "chromedriver-mac-arm64");
        driver = new ChromeDriver();
        driver.get("https://www.k5learning.com/free-math-worksheets");
    }

    @AfterAll
    public static void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void setUpMethod() {
        // Setup code that runs before each test method
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
