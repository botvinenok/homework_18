import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.ContactInPage;
import page.MainPage;

public class ContactPageTest extends InitialTest{

    public MainPage mainPage;
    private ContactInPage contactInPage;
    private String resultMessage = "Please select a subject from the list provided.";

    @BeforeTest
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @DataProvider
    public Object[][] editFieldsForSendMessage(){
        contactInPage =  mainPage.clickContactUs();
        return new Object[][]{
                {resultMessage, contactInPage.editFieldsSendMessage("fdsfd@mail.ry","message")},
                {resultMessage, contactInPage.editFieldsSendMessage("43uiiud@mail.ry","Smthing")}
        };
    }

    @Test(dataProvider = "editFieldsForSendMessage")
    public void checkIfErrorMsgEquals(String actualResult, String expectedResult){
        Assert.assertEquals(actualResult, expectedResult);
    }

}
