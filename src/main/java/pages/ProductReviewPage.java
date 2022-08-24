package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase
{
    public ProductReviewPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTittleTxtBox;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement addReviewTxtBox;

    @FindBy(id = "addproductrating_2")
    WebElement rateProductBrtn;

    @FindBy(css = "div.buttons")
    WebElement submitRviewBtn;

    @FindBy(css = "div.result")
   public WebElement reviewResultMsg;


    public void userSendReview(String tittle, String reviewBody)
    {
        sendText(reviewTittleTxtBox, tittle);
        sendText(addReviewTxtBox, reviewBody);
        clickBtn(rateProductBrtn);
        clickBtn(submitRviewBtn);
    }
}
