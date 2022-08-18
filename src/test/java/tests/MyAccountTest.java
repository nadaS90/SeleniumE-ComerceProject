package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class MyAccountTest extends TestBase{

    HomePage homeObject;
    RegistrationPage rgstrObject;
    LoginPage loginOnject;
    MyAccountPage myAcountObject;
    String firstName ="Nada";
    String lastName = "sayed";
    String email = "test0@example.com";
    String oldPswrd = "p@ssword";
    String newPswrd = "p@ssword1";



    // always run priorty 1
    @Test(priority = 1)
    public void registrationSuccess() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        rgstrObject = new RegistrationPage(driver);
        rgstrObject.userRegistration(firstName, lastName, email, oldPswrd);

        Assert.assertTrue(rgstrObject.successMsg.getText().contains("Your registration completed"));

    }

    @Test(priority = 2)
    public void regstredUserCanChangePswrd()
    {
        rgstrObject.userGoToMyAccount();
        myAcountObject = new MyAccountPage(driver);
        myAcountObject.userChangePswrd();

        myAcountObject.userChangePassword(oldPswrd, newPswrd);
        Assert.assertTrue(myAcountObject.changePwsrdSucessMsg.getText().contains("Password was changed"));

        myAcountObject.closeSuccessMsg();
    }

    @Test(priority = 3)
    public void registrationUserLogout() throws InterruptedException {
        Thread.sleep(3000);
        rgstrObject.userLogout();
    }

    @Test(priority = 4)
    public void registrationUserLogin()
    {
        homeObject.openLoginPage();
        loginOnject = new LoginPage(driver);
        loginOnject.userLogin(email, newPswrd);
//        Thread.sleep(3000);
        //Assert.assertTrue(rgstrObject.logoutLink.getText().contains("Log out"));
//        rgstrObject.logoutLink.isDisplayed();
//        System.out.println(rgstrObject.logoutLink.getText());
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(rgstrObject.myAccountLink.isDisplayed());
        System.out.println(rgstrObject.myAccountLink);


    }

}
