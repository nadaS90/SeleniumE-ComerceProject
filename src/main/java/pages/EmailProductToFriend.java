package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailProductToFriend extends PageBase
{
    public EmailProductToFriend(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (id = "FriendEmail")
    WebElement fiendEmailTxtBox;

    @FindBy(id = "YourEmailAddress")
   public WebElement myEmailTxtBox;

    @FindBy (id = "PersonalMessage")
    WebElement msgTxtBox;

    @FindBy(css = "div.buttons")
    WebElement submitBtn;

    @FindBy(css = "div.result")
    public WebElement submitSucessMsg;


    public void emailAFriendProduct(String frndEmail, String message)
    {
        sendText(fiendEmailTxtBox, frndEmail);
        sendText(msgTxtBox, message);
        clickBtn(submitBtn);
    }

}
