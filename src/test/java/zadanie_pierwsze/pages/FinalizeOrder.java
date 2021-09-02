package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalizeOrder {



@FindBy(name = "confirm-addresses")
    private WebElement confirmAddresses;


@FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOption;

@FindBy(xpath = "//input[@id = 'payment-option-1']")
    private WebElement payByCheck;

@FindBy(xpath = "//dd[normalize-space()='€143.60 (tax incl.)']")
    private WebElement finalPrice;

@FindBy(xpath = "//input[@id = 'conditions_to_approve[terms-and-conditions]']")
    private WebElement approveTermsOfService;

@FindBy(xpath = "//button[@class = 'btn btn-primary center-block']")
    private WebElement confirmOrder;

public FinalizeOrder(WebDriver driver) {
    PageFactory.initElements(driver,this);

}

public void confirmAddress() {
    confirmAddresses.click();
}



public void confirmDelivery() {
    confirmDeliveryOption.click();
}


public void payByCheckPlease() {
    payByCheck.click();

}
public boolean  checkDiscount() {

 return finalPrice.getText().equals("€143.60 (tax incl.)");

}

public void termsOfService() {
    approveTermsOfService.click();
}

public void orderWithAnObligationToPay() {
    confirmOrder.click();
}
}
