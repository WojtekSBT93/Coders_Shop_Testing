package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HummingbirdPrintedSweaterPage {

    @FindBy(xpath = "//span[normalize_space(@content) = '28.72']")
    private WebElement priceWithDiscount;

    @FindBy(xpath = "//input[@aria-label = 'Quantity']")
    private WebElement quantityAdd;

    @FindBy(id = "group_1")
    private WebElement whatSize;

    @FindBy(xpath = "//option[@value ='2']")
    private WebElement sizeM;


    @FindBy(xpath = "//button[@class = 'btn btn-primary add-to-cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    private WebElement proceedToCheckout;



    public HummingbirdPrintedSweaterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDiscountAdded() {
        return priceWithDiscount.getText().equals("€28.72");
    }

    public void chooseQuantity(String value) {
        quantityAdd.click();
        quantityAdd.clear();
        quantityAdd.sendKeys(value);


    }

    public void chooseSize() {
        whatSize.click();
        sizeM.click();
    }

    public void addClothesToCart() {
        addToCart.click();
    }

    public void proceedToCheckoutSubmit() {

        proceedToCheckout.click();
    }
}
