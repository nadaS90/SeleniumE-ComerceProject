package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class MyAccountTest extends TestBase
{
    HomePage homeObject ;
    RegistrationPage rgstrObject;
    LoginPage loginObject ;
    MyAccountPage myAccountObject ;
    String oldPswrd = "p@ssword" ;
    String newPswrd = "p@ssword" ;
    String firstName = "Nada" ;
    String lastName = "Sayed" ;
    String email = "test@example.com" ;


    @Test(priority=1)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        rgstrObject = new RegistrationPage(driver);
        rgstrObject.userRegistration(firstName, lastName, email, oldPswrd);
        Assert.assertTrue(rgstrObject.successMsg.getText().contains("Your registration completed"));
    }

    @Test(priority=2)
    public void RegisteredUserCanChangePassword()
    {
        myAccountObject = new MyAccountPage(driver) ;
        rgstrObject.openMyAccountPage();
        myAccountObject.userChangePassword();
        myAccountObject.userChangesPassword(oldPswrd, newPswrd);
        Assert.assertTrue(myAccountObject.changePwsrdSucessMsg.getText().contains("Password was changed"));

        myAccountObject.closeSuccessMessage();
    }

    @Test(priority=3)
    public void RegisteredUserCanLogout() throws InterruptedException {
        Thread.sleep(3000);
        rgstrObject.userLogout();
    }

    @Test(priority=4)
    public void RegisteredUserCanLogin()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, newPswrd);
        Assert.assertTrue(rgstrObject.logoutLink.getText().contains("Log out"));
        System.out.println(rgstrObject.logoutLink.getText());
    }

//	@Test(priority=5)
//	public void UserLogout()
//	{
//		registerObject.userLogout();
//	}
//
}
