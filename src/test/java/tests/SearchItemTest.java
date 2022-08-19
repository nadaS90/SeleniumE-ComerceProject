package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SearchItemTest extends  TestBase
{
    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;

    String producrName = "Apple MacBook Pro 13-inch";

    @Test
    public void seachForItems()
    {
        searchObject = new SearchItmPage(driver);
        itemsObject = new ItemsDetailsPage(driver);
        searchObject.productSearch(producrName);
        searchObject.openitemDetails();
        Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(producrName));

      // itemsObject = new ItemsDetailsPage(driver);
       // Assert.assertTrue(itemsObject.itemName.getText().equals(producrName));
    }
}
