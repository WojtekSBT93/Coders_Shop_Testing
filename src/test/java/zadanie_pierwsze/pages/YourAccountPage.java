package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



    public class YourAccountPage {

        @FindBy(xpath = "//i[@class='material-icons'][normalize-space()='\uE567']")
        private WebElement addressesPage;
        @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
        private WebElement searchBar;

        public YourAccountPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void clickAddFirstAddressBtn() {
            addressesPage.click();
        }

        public void setSearchBar(String searchValue){
            searchBar.sendKeys(searchValue);
            searchBar.submit();
        }

    }

