package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemsDetailsPage;
import pages.SearchItmPage;
import pages.WishListPage;

public class AddItemWishListTest extends TestBase
{
    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;
    WishListPage wishObject;

    String producrName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void addItemToTheWishList()
    {

        itemsObject = new ItemsDetailsPage(driver);
        itemsObject.usedAddItemWishList();

        Assert.assertTrue(itemsObject.sucessMsgWishList.getText().contains("The product has been added to your wishlist"));
        itemsObject.closeMessageWishList();
    }

    @Test(priority = 3)
    public void checkItemsFoundWishList()
    {
        driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
        wishObject = new WishListPage(driver);
        Assert.assertTrue(wishObject.pageTitle.isDisplayed());
        Assert.assertTrue(wishObject.itemsListWish.getText().contains(producrName));
        System.out.println(wishObject.itemsListWish.getText());
    }

    @Test(priority = 4)
    public void removeItemsFromwishList()
    {
        wishObject = new WishListPage(driver);
        wishObject.removeProductFromWishlist();
        Assert.assertTrue(wishObject.EmptyCartLbl.getText().contains("The wishlist is empty!"));
    }

}
