package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{
    ContactUsPage contactObject;
    HomePage homeObject;

    String userName = "Test User";
    String userEmail = "test100@example.com";
    String enquiry = "Hello Test";


    @Test
    public void userSendEnquiry()
    {
        contactObject = new ContactUsPage(driver);
        homeObject = new HomePage(driver);

        homeObject.openContactUsPage();
        contactObject.userSendEnquiry(userName, userEmail, enquiry);

        Assert.assertTrue(contactObject.sbmtResult.getText()
                .contains("Your enquiry has been successfully sent to the store owner."));
    }
}
