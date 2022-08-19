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
}
