package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductReviewPageTest extends TestBase
{
    HomePage homeObject ;
    RegistrationPage rgstrObject;
    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;
    ProductReviewPage reviewObject;


    String firstName = "Nada" ;
    String lastName = "Sayed" ;
    String email = "test70@example.com" ;
    String password = "p@ssword" ;
    String producrName = "Apple MacBook Pro 13-inch";
    String tittle = "Great";
    String reviewBody = "The product is good";

    @Test(priority = 1)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        rgstrObject = new RegistrationPage(driver);
        rgstrObject.userRegistration(firstName, lastName, email, password);
        Assert.assertTrue(rgstrObject.successMsg.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void seachForItemsWithAutoComplete() {

        try {
            searchObject = new SearchItmPage(driver);
            searchObject.productSearchWithAutoComplete("MacB");
            itemsObject = new ItemsDetailsPage(driver);
            Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(producrName));
        } catch (Exception e) {
            System.out.println("Wehave error " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void userCanAddRevirewToProduct()
    {
        itemsObject = new ItemsDetailsPage(driver);
        itemsObject.usedAddReview();
        reviewObject = new ProductReviewPage(driver);
        reviewObject.userSendReview(tittle, reviewBody);
        Assert.assertTrue(reviewObject.reviewResultMsg.getText().contains("Product review is successfully added."));

    }

    @Test(priority = 4)
    public void registrationUserLogout()
    {
        rgstrObject.userLogout();
    }

}
