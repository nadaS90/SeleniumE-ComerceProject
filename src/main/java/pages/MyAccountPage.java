package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class MyAccountPage extends PageBase
{
    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (linkText = "Change password")
    WebElement changePswrd;

    @FindBy(id = "OldPassword")
    WebElement changeOldPswrd;

    @FindBy(id = "NewPassword")
    WebElement addNewPswrd;

    @FindBy(id = "ConfirmNewPassword")
    WebElement cnfrmPswrd;

    @FindBy(css="button.change-password-button")
    WebElement changePswrdBtn ;

//    @FindBy(css = "#bar-notification > div > p")
//    WebElement pswrdSuccessMsg;

    @FindBy(css = "p.content")
   public WebElement changePwsrdSucessMsg;
    // need to be public so other packages can see it for assertion

    @FindBy(css = "span.close")
    WebElement closeMsg;

//    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
//    WebElement logoutLink ;


    public void userChangePswrd()
    {
        clickBtn(changePswrd);
    }
    public void userChangePassword(String oldPswrd, String newPswrd)
    {
        sendText(changeOldPswrd, oldPswrd);
        sendText(addNewPswrd, newPswrd);
        sendText(cnfrmPswrd, newPswrd);
        clickBtn(changePswrdBtn);
    }

    public void closeSuccessMsg()
    {
        clickBtn(closeMsg);
    }

//    public void userLogout()
//    {
//        clickBtn(logoutLink);
//    }
}
