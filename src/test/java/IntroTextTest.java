import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class IntroTextTest extends K5Test{
    @Test
    public void testIntroTextWithAllPOMs() {
        IntroPage introPage = new IntroPage(driver);
        BenefitsPage benefitsPage = new BenefitsPage(driver);
        FooterPage footerPage = new FooterPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        // Interaction with IntroPage
        String introText = introPage.getIntroText();
        boolean isIntroTextCorrect = introText.contains("Reading & Math for K-5");
        Assertions.assertTrue(isIntroTextCorrect, AssertionMessages.introNameInCorrect);

        // Interaction with BenefitsPage
        benefitsPage.clickContactLink();
        // Interaction with FooterPage
        footerPage.scrollToFooter();
        // Interaction with SearchPage
        searchPage.searchFor("fractions"); // Assuming a method to perform a search for "fractions" in the search page
        Assertions.assertTrue(driver.getPageSource().contains("fractions"), AssertionMessages.searchUnSuccessful);
    }


    @Test
    public void testIntroTextAfterNavigation(){
        IntroPage introPage = new IntroPage(driver);
        BenefitsPage benefitsPage = new BenefitsPage(driver);

        // Navigate to benefits page and then return
        benefitsPage.navigateToBenefits();
        driver.navigate().back();

        // Check the intro text again after returning
        String text = introPage.getIntroText();
        boolean isTextCorrect = text.contains("Reading & Math for K-5");
        Assertions.assertTrue(isTextCorrect, AssertionMessages.introNameInCorrect);

    }

    @Test
    public void testIntroTextAfterFooterNavigation(){
        IntroPage introPage = new IntroPage(driver);
        FooterPage footerPage = new FooterPage(driver);

        // Initially checking the intro text
        String initialIntroText = introPage.getIntroText();
        Assertions.assertTrue(initialIntroText.contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);

        // Navigate to footer page and then return
        footerPage.scrollToFooter();
        driver.navigate().back();

        // Check the intro text again after returning
        String returnedIntroText = introPage.getIntroText();
        Assertions.assertTrue(returnedIntroText.contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);
    }

}
