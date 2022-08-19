package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistratinTest extends TestBase{
    // Create objects from home & Registration pages
    HomePage homeObject;
    RegistrationPage rgstrObject;
    LoginPage loginOnject;

    // Create Tests

    // always run priorty 1
    @Test(priority = 1, alwaysRun = true)
    public void registrationSuccess()
    {
        // must create new instance that we have " deriver" that inhiret from testBse so we can use it
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        rgstrObject = new RegistrationPage(driver);
        rgstrObject.userRegistration("Nada", "sayed", "test126@gmail.com", "12345678");;

        Assert.assertTrue(rgstrObject.successMsg.getText().contains("Your registration completed"));

    }

    // in depends on method we write the name of the method that will depend on the other to execute
    @Test(dependsOnMethods = {"registrationSuccess"})
    public void registrationUserLogout()
    {
        rgstrObject.userLogout();
    }

    @Test(dependsOnMethods = {"registrationUserLogout"})
    public void registrationUserLogin()
    {
        homeObject.openLoginPage();
        loginOnject = new LoginPage(driver);
        loginOnject.userLogin("test126@gmail.com", "12345678");
        Assert.assertTrue(rgstrObject.logoutLink.getText().contains("Log out"));
    }



}
