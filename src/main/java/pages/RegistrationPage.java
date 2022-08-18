package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase
{
    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(id="gender-female")
    WebElement genderBtn ;

    @FindBy(id="FirstName")
    WebElement firstNameTxtBox;

    @FindBy(id="LastName")
    WebElement lasstNameTxtBox ;

    @FindBy(id="Email")
    WebElement emailTxtBox ;

    @FindBy(id="Password")
    WebElement passwordTxtBox ;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordTxtBox ;

    @FindBy(id="register-button")
    WebElement registerBtn ;

    @FindBy(className = "result")
    public WebElement successMsg;

    @FindBy(css="a.ico-logout")
    public WebElement logoutLink ;

    @FindBy(linkText = "My account")
    public WebElement myAccountLink ;



    public void userRegistration(String firstName , String lastName , String email , String password)
    {
        clickBtn(genderBtn);
        sendText(firstNameTxtBox, firstName);
        sendText(lasstNameTxtBox, lastName);
        sendText(emailTxtBox, email);
        sendText(passwordTxtBox, password);
        sendText(confirmPasswordTxtBox, password);
        clickBtn(registerBtn);
    }

    public void userLogout()
    {
        clickBtn(logoutLink);
    }

    public void userGoToMyAccount()
    {
        clickBtn(myAccountLink);
    }

}



