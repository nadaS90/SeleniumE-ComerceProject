package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItmPage extends PageBase{

    public SearchItmPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy (id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement seachBtn;

    @FindBy(id = "ui-id-2")
    WebElement searcDropDownResult;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement searchResult;

    public void productSearch ( String productName)
    {
        sendText(searchBox, productName);
        clickBtn(seachBtn);
    }

    public void openitemDetails()
    {
        clickBtn(searchResult);
    }




}
