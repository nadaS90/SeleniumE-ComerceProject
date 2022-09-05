package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddItemToCart extends PageBase
{
    public AddItemToCart(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement firstItemCart;

    @FindBy(css = "div.total-info")
    public WebElement totalAmount;

    @FindBy(css = "button.remove-btn")
    WebElement removeBtn;

    public void removeItemFromCart()
    {
        clickBtn(removeBtn);
    }







}
