package zadanie_pierwsze.pages;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class OrderIsConfirmed {

    @FindBy(xpath = "//body[@id ='order-confirmation']")
    private WebElement orderIsConfirmed;

    public OrderIsConfirmed(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
        public void screenshotOfOrder(){
            orderIsConfirmed.getScreenshotAs(OutputType.BYTES);
        }

    }

