package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class MyAccountTest extends TestBase
{
    HomePage homeObject ;
    RegistrationPage registerObject ;
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
        registerObject = new RegistrationPage(driver);
        registerObject.userRegistration(firstName, lastName, email, oldPswrd);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
    }

    @Test(priority=2)
    public void RegisteredUserCanChangePassword()
    {
        myAccountObject = new MyAccountPage(driver) ;
        registerObject.openMyAccountPage();
        myAccountObject.userChangePassword();
        myAccountObject.userChangesPassword(oldPswrd, newPswrd);
        Assert.assertTrue(myAccountObject.changePwsrdSucessMsg.getText().contains("Password was changed"));

        myAccountObject.closeSuccessMessage();
    }

    @Test(priority=3)
    public void RegisteredUserCanLogout() throws InterruptedException {
        Thread.sleep(3000);
        registerObject.userLogout();
    }

    @Test(priority=4)
    public void RegisteredUserCanLogin()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, newPswrd);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
        System.out.println(registerObject.logoutLink.getText());
    }

//	@Test(priority=5)
//	public void UserLogout()
//	{
//		registerObject.userLogout();
//	}
//
}
