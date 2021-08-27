package zadanie_pierwsze.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    @FindBy(xpath = "//*[@name='alias']")
    private WebElement alias;
    @FindBy(xpath = "//*[@name='address1']")
    private WebElement address;
    @FindBy(xpath = "//*[@name='city']")
    private WebElement city;
    @FindBy(xpath = "//*[@name='postcode']")
    private WebElement zipCode;
    @FindBy(xpath = "//*[@name='id_country']")
    private WebElement countryDropDown;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumber;
    @FindBy (xpath = "//button[@class='btn btn-primary float-xs-right']")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void funEnterAddressForm( AddressFormData formData) {
        setInput(alias, formData.getAlias());
        setInput(address, formData.getAddress());
        setInput(city, formData.getCity());
        setInput(zipCode, formData.getZipCode());
        Select select = new Select(countryDropDown);
        select.selectByIndex(1);
        setInput(phoneNumber, formData.getPhoneNumber());
    }

    public void clickSaveBtn(){
        saveButton.click();
    }

    private void setInput( WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
    }

    private void setInput( WebElement input, int value) {
        input.clear();
        input.sendKeys(String.valueOf(value));
    }
}


