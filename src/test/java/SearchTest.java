import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class SearchTest extends K5Test {

    @Test
    public void testSuccessfulSearch() {
            IntroPage introPage = new IntroPage(driver);
            BenefitsPage benefitsPage = new BenefitsPage(driver);
            FooterPage footerPage = new FooterPage(driver);
            SearchPage searchPage = new SearchPage(driver);

            benefitsPage.navigateToBenefits();
            Assertions.assertTrue(benefitsPage.isAt(), AssertionMessages.benefitsPageNotShown);

            //After all these still search input has to be enabled
            String keyword = "decimals";
            searchPage.searchFor(keyword);
            Assertions.assertTrue(searchPage.isSearchSuccessful(keyword), AssertionMessages.searchUnSuccessful);

            // Verify intro text in this new page
            String introText = introPage.getIntroText();
            Assertions.assertTrue(introText.contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);

            // Scroll to footer
            footerPage.scrollToFooter();
            Assertions.assertTrue(footerPage.isAtFooter(), AssertionMessages.scrollToFooterDisabled);

    }


    @Test
    public void testEmptySearch(){
        SearchPage searchPage = new SearchPage(driver);
        IntroPage introPage = new IntroPage(driver);

        // Perform empty search
        searchPage.searchFor("");
        Assertions.assertTrue(searchPage.isSearchSuccessful(""), AssertionMessages.searchUnSuccessful);

        Assertions.assertTrue(introPage.getIntroText().contains("Reading & Math for K-5"), AssertionMessages.searchUnSuccessful);

    }


}
