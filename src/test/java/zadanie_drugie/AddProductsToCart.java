package zadanie_drugie;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import zadanie_pierwsze.pages.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddProductsToCart {

    private WebDriver driver;
    private  HomePage homePage;
    private LogInToYourAccount logInToYourAccount;
    private YourAccountPage yourAccountPage;
    private SearchResultPage searchResultPage;
    private HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage;
    private ShoppingCartPage shoppingCartPage;
    private FinalizeOrder finalizeOrder;
    private OrderIsConfirmed orderIsConfirmed;




    @Given("^User is logged in his account$")
    public void userIsLoggedInHisAccount() throws IOException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");
        //TakesScreenshot scrShot =((TakesScreenshot)driver);
        homePage = new HomePage(driver);
        logInToYourAccount = new LogInToYourAccount(driver);
        yourAccountPage = new YourAccountPage(driver);
        searchResultPage = new SearchResultPage(driver);
        hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        finalizeOrder = new FinalizeOrder(driver);
        orderIsConfirmed = new OrderIsConfirmed(driver);
        homePage.clickSignIn();
        String emailValue = "StephanieRKoon@teleworm.us";
        logInToYourAccount.fillEmailToSignIn(emailValue);
        String passwordValue = "Jacek25";
        logInToYourAccount.fillPasswordToSignIn(passwordValue);
        logInToYourAccount.clickSignInBtn();


    }

    @When("^User enter product name in searchbar$")
    public void userEnterProductNameInSearchbar() {
        String searchFor = "Hummingbird Printed Sweater";
        yourAccountPage.setSearchBar(searchFor);
    }

    @And("^User choose Hummingbird Printed Sweater$")
    public void userChooseHummingbirdPrintedSweater() {
        searchResultPage.chooseYourClothes();

    }

    @And("^User choose size and quantity$")
    public void userChooseSizeAndQuantity() {

        hummingbirdPrintedSweaterPage.chooseSize();
        hummingbirdPrintedSweaterPage.chooseQuantity("5");
        hummingbirdPrintedSweaterPage.addClothesToCart();
        hummingbirdPrintedSweaterPage.proceedToCheckoutSubmit();

    }


    @And("^User confirm proceed to checkout$")
    public void userConfirmProceedToCheckout() {
        shoppingCartPage.proceedToCheckoutConfirm();
    }

    @And("^User confirm address$")
    public void userConfirmAddress() {
        finalizeOrder.confirmAddress();
    }

    @And("^User confirm delivery option$")
    public void userConfirmDeliveryOption() {
        finalizeOrder.confirmDelivery();
    }

    @And("^User choose pay by check$")
    public void userChoosePayByCheck() {
        finalizeOrder.payByCheckPlease();

    }

    @And("^Discount will be correctly charged$")
    public void discountWillBeCorrectlyCharged() {
        assertTrue(finalizeOrder.checkDiscount());
    }

    @And("^User agree to the terms of service$")
    public void userAgreeToTheTermsOfService() {
        finalizeOrder.termsOfService();
    }

    @And("^User confirm order with an obligation to pay$")
    public void userConfirmOrderWithAnObligationToPay() {
        finalizeOrder.orderWithAnObligationToPay();

    }



    @Then("^User see info your order is confirmed$")
    public void userSeeInfoYourOrderIsConfirmed() throws IOException {
        orderIsConfirmed.screenshotOfOrder();
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("/Users/wojciechborowiak/FinalExcersises/src/test/resources/Screenshots"));




    }

}
