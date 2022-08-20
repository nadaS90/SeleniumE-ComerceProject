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


    public void emailProductToAFriend()
    {
        clickBtn(emailAFriend);
    }
}
