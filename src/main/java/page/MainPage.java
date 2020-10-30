package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement buttonSearch;

    /*****************************************************************************/

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ContactInPage clickContactUs(){
        buttonSignIn.click();
        return new ContactInPage(driver);
    }

    public SearchResultPage clickSearchButton(){
        buttonSearch.click();
        return new SearchResultPage(driver);
    }

    public MainPage editSearchField(String searchValue){
        searchField.clear();
        searchField.sendKeys(searchValue);
        return this;
    }


}
