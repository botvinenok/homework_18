package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='product_img_link']")
    private WebElement product;

    /*****************************************************************************/

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String productTitle(){
        return  product.getAttribute("title");
    }


}
