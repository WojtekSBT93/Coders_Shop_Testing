package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    @FindBy(xpath = "//a[@href = 'https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s']")
    private WebElement sweater;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void chooseYourClothes() {
        sweater.click();
    }


}
