package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemsDetailsPage;
import pages.SearchItmPage;

public class SearchItemWithAutoCompleteTest extends  TestBase
{
    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;
    String producrName = "Apple MacBook Pro 13-inch";


    @Test
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
}
