package pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends Header{
    @FindBy(xpath = "//div[@class='product-line-info']//a")
    private WebElement productLink;

    @FindBy(className = "product-price")
    private WebElement productPriceLbl;

    @FindBy(name = "product-quantity-spin")
    private WebElement productOrderedQuantityTF;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement orderingBtn;

    public BasketPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        wait.until(ExpectedConditions.elementToBeClickable(productLink));
        return productLink.getText();
    }

    public int getProductOrderedQuantity(){
        wait.until(ExpectedConditions.elementToBeClickable(productOrderedQuantityTF));
        return Integer.parseInt(productOrderedQuantityTF.getAttribute("value"));
    }

    public double getProductPrice(){
        wait.until(ExpectedConditions.visibilityOf(productPriceLbl));
        String value = productPriceLbl.getText().split(" ")[0];
        return Double.valueOf(value.replace(',', '.'));
    }

    public void goToOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(orderingBtn));
        orderingBtn.click();
    }
}
