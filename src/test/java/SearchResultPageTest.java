import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;
import page.SearchResultPage;

public class SearchResultPageTest extends InitialTest{

    private MainPage mainPage;
    private SearchResultPage searchResultPage;

    @BeforeTest
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void searchIfProductBlouseExist() {
        mainPage.editSearchField("Blouse");
        searchResultPage = mainPage.clickSearchButton();

        System.out.println("First test: Blouse");
        String actualResult = searchResultPage.productTitle();
        String expectedResult = "Blouse";
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void searchIfProductDressExist() {
        mainPage.editSearchField("Dress");
        searchResultPage = mainPage.clickSearchButton();

        System.out.println("Second test: Dress");
        String actualResult = searchResultPage.productTitle();
        String expectedResult = "Dress";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
