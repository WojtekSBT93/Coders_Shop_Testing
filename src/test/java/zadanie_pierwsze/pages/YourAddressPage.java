package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressPage {

    @FindBy(xpath = "//li[normalize-space()='Address successfully added!']")
    private WebElement successText;
    @FindBy(xpath = "//span[normalize-space()='Delete']")
    private WebElement deleteAddressBtn;
    @FindBy(xpath = "//li[normalize-space()='Address successfully deleted!']")
    private WebElement deleteText;

    public YourAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isAddressAddSuccess() {
        return successText.getText().equals("Address successfully added!");
    }

    public void deleteAddress() {
        deleteAddressBtn.click();
    }

    public boolean isAddressAddDeleted() {
        return deleteText.getText().equals("Address successfully deleted!");
    }
}


