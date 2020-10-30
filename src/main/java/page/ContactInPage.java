package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@id='submitMessage']")
    private WebElement buttonSendMsg;

    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement messageField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    private WebElement messageError;

    /*****************************************************************************/

    public ContactInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ContactInPage editMessageField(String message){
        messageField.clear();
        messageField.sendKeys(message);
        return this;
    }

    public ContactInPage clickSendMessageButton(){
        buttonSendMsg.click();
        return this;
    }

    public ContactInPage editEmailField(String email){
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public String getErrorMessage(){
        return messageError.getText();
    }

    public String editFieldsSendMessage(String emailField, String messageField){
        editEmailField(emailField);
        editMessageField(messageField);
        clickSendMessageButton();
        return getErrorMessage();
    }

}
