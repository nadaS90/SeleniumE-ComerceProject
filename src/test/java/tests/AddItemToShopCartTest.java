package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddItemToCart;
import pages.ItemsDetailsPage;
import pages.SearchItmPage;

public class AddItemToShopCartTest extends TestBase
{
    String firstItem = "Asus N551JK-XO076H Laptop";

    SearchItmPage searchObject;
    ItemsDetailsPage itemsObject;
    AddItemToCart  cartObject;


    @Test(priority = 1)
    public void seachForItemsWithAutoComplete()
    {

        try {
            searchObject = new SearchItmPage(driver);
            searchObject.productSearchWithAutoComplete("N551JK-XO076H");
            itemsObject = new ItemsDetailsPage(driver);
            Assert.assertTrue(itemsObject.itemName.getText().equalsIgnoreCase(firstItem));
        } catch (Exception e)
        {
            System.out.println("Wehave error " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void userAddItemToShoppingCart()
    {
        itemsObject = new ItemsDetailsPage(driver);
        itemsObject.addItemToCart();
        Assert.assertTrue(itemsObject.sucessMsgWishList.getText().contains("The product has been added to your "));
        System.out.println(itemsObject.sucessMsgWishList.getText());
        itemsObject.closeMessageWishList();
    }

    @Test(priority = 3)
    public void CheckItemFoundInChartPage()
    {
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        cartObject = new AddItemToCart(driver);
        Assert.assertTrue(cartObject.firstItemCart.getText().contains("N551JK-XO076H"));
        Assert.assertTrue(cartObject.totalAmount.getText().contains("$1,500.00"));
    }

    @Test(priority = 4)
    public void UserCanRemoveItemFromCart()
    {
        cartObject = new AddItemToCart(driver);
        cartObject.removeItemFromCart();
    }


}
