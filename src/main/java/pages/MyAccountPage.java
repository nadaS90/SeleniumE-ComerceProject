package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{

        public MyAccountPage(WebDriver driver)
        {
            super(driver);
        }

        @FindBy(linkText="Change password")
        WebElement changePswrd;

        @FindBy(id = "OldPassword")
        WebElement changeOldPswrd;

        @FindBy(id = "NewPassword")
        WebElement addNewPswrd;

        @FindBy(id = "ConfirmNewPassword")
        WebElement cnfrmPswrd;

        @FindBy(css="button.change-password-button")
        WebElement changePswrdBtn ;

        @FindBy(css = "p.content")
        public WebElement changePwsrdSucessMsg;

        @FindBy(css = "span.close")
        WebElement closeMsg;

        public void userChangePassword()
        {
            clickBtn(changePswrd);
        }

        public void userChangesPassword(String oldPswrd, String newPswrd)
        {
            sendText(changeOldPswrd, oldPswrd);
            sendText(addNewPswrd, newPswrd);
            sendText(cnfrmPswrd, newPswrd);
            clickBtn(changePswrdBtn);
        }

        public void closeSuccessMessage()
        {
            clickBtn(closeMsg);
        }


}
