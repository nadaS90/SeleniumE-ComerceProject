package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase
{
    public WishListPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(css = "h1")
    public WebElement pageTitle;

    @FindBy(css = "td.product")
    public WebElement itemsListWish;

    @FindBy(css = "button.remove-btn")
     WebElement removeItems;

    @FindBy(css = "div.no-data")
    public WebElement EmptyCartLbl;

    public void removeProductFromWishlist()
    {
        clickBtn(removeItems);
    }



}


