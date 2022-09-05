package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsDetailsPage extends PageBase{
    public ItemsDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "div.product-name")
    public WebElement itemName;

    @FindBy(css = "div.email-a-friend")
    public WebElement emailAFriend;

    @FindBy(id = "price-value-4")
    public WebElement crncyType;

    @FindBy(linkText = "Add your review")
    public  WebElement addyourreview;

    @FindBy(id = "add-to-wishlist-button-4")
    public WebElement addWishList;

    @FindBy(css = "p.content")
    public WebElement sucessMsgWishList;

    @FindBy(css = "span.close")
   public WebElement closeMsg;

    @FindBy(css = "div.compare-products")
    WebElement compareProductBtn;

    @FindBy(id = "add-to-cart-button-5")
    WebElement addToCart;


    public void emailProductToAFriend()
    {
        clickBtn(emailAFriend);
    }

    public void usedAddReview()
    {
        clickBtn(addyourreview);
    }

    public void usedAddItemWishList()
    {
        clickBtn(addWishList);
    }

    public void closeMessageWishList()
    {
        clickBtn(closeMsg);
    }

    public void usedAdditemToCompare()
    {
        clickBtn(compareProductBtn);
    }

    public void addItemToCart()
    {clickBtn(addToCart);}
}
