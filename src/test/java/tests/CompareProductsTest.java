package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductPage;
import pages.HomePage;
import pages.ItemsDetailsPage;
import pages.SearchItmPage;

public class CompareProductsTest extends TestBase
{

    String fristProduct = "HTC One M8 Android L 5.0 Lollipop";
    String secondProduct = "HTC One Mini Blue";

    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;
    CompareProductPage compareObject;
    HomePage homeObject;

    @Test(priority = 1)
    public void CompareBetweenProducts() throws InterruptedException {
        searchObject = new SearchItmPage(driver);
        itemsObject = new ItemsDetailsPage(driver);
        compareObject = new CompareProductPage(driver);


        searchObject.productSearchWithAutoComplete("Lollipop");
        Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(fristProduct));
        itemsObject.usedAdditemToCompare();
        Assert.assertTrue(itemsObject.sucessMsgWishList.getText().contains("The product has been added to your product comparison"));
        System.out.println(itemsObject.sucessMsgWishList.getText());
        itemsObject.closeMessageWishList();

        searchObject.productSearchWithAutoComplete("Blue");
        Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(secondProduct));
        itemsObject.usedAdditemToCompare();
        Assert.assertTrue(itemsObject.sucessMsgWishList.getText().contains("The product has been added to your product comparison"));
        System.out.println(itemsObject.sucessMsgWishList.getText());
        itemsObject.closeMessageWishList();

        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
        compareObject.compareProducts();

    }

    @Test(priority = 2)
    public void clearCompareList()
    {
        compareObject.ClearCompaeList();
    }


    // search product 1
    // search product 2
    // add to compare
    // clear list
}
