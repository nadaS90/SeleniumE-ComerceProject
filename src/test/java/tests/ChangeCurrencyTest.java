package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemsDetailsPage;
import pages.LoginPage;
import pages.SearchItmPage;

public class ChangeCurrencyTest extends TestBase {
    HomePage homeObject;
    ItemsDetailsPage itemsObject;
    SearchItmPage searchObject;

    String producrName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void userChangeCurrency() {
        homeObject = new HomePage(driver);
        homeObject.changeCrncy();

    }

    @Test(priority = 2)
    public void seachForItemsWithAutoComplete() {

        try {
            searchObject = new SearchItmPage(driver);
            searchObject.productSearchWithAutoComplete("MacB");
            itemsObject = new ItemsDetailsPage(driver);
            Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(producrName));
            Assert.assertTrue((itemsObject.crncyType.getText().contains("€")));
            System.out.println(itemsObject.crncyType.getText());
        } catch (Exception e) {
            System.out.println("We have error " + e.getMessage());
        }

    }

}
