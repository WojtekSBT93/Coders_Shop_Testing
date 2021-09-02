package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {

    @FindBy(xpath = "//a[@href = 'https://prod-kurs.coderslab.pl/index.php?controller=address']")
    private WebElement createNewAddress;

    public AddressesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    public void createNewAddresButton() {

        createNewAddress.click();
    }
}
