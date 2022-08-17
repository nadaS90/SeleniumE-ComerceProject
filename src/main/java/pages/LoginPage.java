package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

import static org.openqa.selenium.Keys.ENTER;

public class LoginPage extends PageBase
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement pswrdTxtBox;

    // type of element is input
    @FindBy(css="button.login-button")
    WebElement loginBtn ;

    public void userLogin(String emil , String password)
    {
        sendText(emailTxtBox, emil);
        sendText(pswrdTxtBox, password);
        clickBtn(loginBtn);
       // pswrdTxtBox.sendKeys(ENTER);

        System.out.println(emailTxtBox);
        System.out.println(pswrdTxtBox);
        System.out.println(loginBtn);

    }








}
