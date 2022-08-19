package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

    public ContactUsPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(id = "FullName")
    WebElement addUserNameBox;

    @FindBy(id = "Email")
    WebElement addUserEmailBox;

    @FindBy(id = "Enquiry")
    WebElement enquiryBox;

    @FindBy(css = "div.buttons")
    WebElement sbmtBtn;

    @FindBy(css = "div.result")
    public WebElement sbmtResult;



    public void userSendEnquiry(String usrName, String usrEmail, String enquiry)
    {
        sendText(addUserNameBox, usrName);
        sendText(addUserEmailBox, usrEmail);
        sendText(enquiryBox, enquiry);
        clickBtn(sbmtBtn);
    }
}
