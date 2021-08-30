package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @FindBy(xpath = "//a[@class ='btn btn-primary']")
    private WebElement confirmProceedToCheckout;


    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void proceedToCheckoutConfirm() {

        confirmProceedToCheckout.click();
    }
}
