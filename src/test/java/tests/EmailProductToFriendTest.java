package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailProductToFriendTest extends TestBase
{
    HomePage homeObject ;
    RegistrationPage rgstrObject;
    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;
    EmailProductToFriend emailObject;


    String firstName = "Nada" ;
    String lastName = "Sayed" ;
    String email = "test20@example.com" ;
    String password = "p@ssword" ;
    String producrName = "Apple MacBook Pro 13-inch";
    String frndEmail = "test098@example.com";
    String message = " Check this dude!";

    @Test(priority = 1)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        rgstrObject = new RegistrationPage(driver);
        rgstrObject.userRegistration(firstName, lastName, email, password);
        Assert.assertTrue(rgstrObject.successMsg.getText().contains("Your registration completed"));
    }

//    @Test(priority = 2)
//    public void RegisteredUserCanLogin()
//    {
//        homeObject.openLoginPage();
//        loginObject = new LoginPage(driver);
//        loginObject.userLogin(email, newPswrd);
//        Assert.assertTrue(rgstrObject.logoutLink.getText().contains("Log out"));
//        System.out.println(rgstrObject.logoutLink.getText());
//    }

    @Test(priority = 2)
    public void seachForItemsWithAutoComplete() {

        try {
            searchObject = new SearchItmPage(driver);
            searchObject.productSearchWithAutoComplete("MacB");
            itemsObject = new ItemsDetailsPage(driver);
            Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(producrName));
        } catch (Exception e)
        {
            System.out.println("Wehave error " + e.getMessage());
        }
    }

    @Test (priority = 3)
    public void userCanEmailProductToFriend()
    {
        itemsObject.emailProductToAFriend();

        emailObject = new EmailProductToFriend(driver);
        emailObject.emailAFriendProduct(frndEmail, message);
//        Assert.assertTrue(emailObject.myEmailTxtBox.getText().contains(email));
//        System.out.println(emailObject.myEmailTxtBox);
        Assert.assertTrue(emailObject.submitSucessMsg.getText().contains("Your message has been sent."));
    }

    @Test(priority = 4)
    public void registrationUserLogout()
    {
        rgstrObject.userLogout();
    }


}
