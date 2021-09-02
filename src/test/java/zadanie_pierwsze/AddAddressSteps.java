package zadanie_pierwsze;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import zadanie_pierwsze.pages.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddAddressSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LogInToYourAccount logInToYourAccount;
    private YourAccountPage yourAccountPage;
    private NewAddressPage newAddressPage;
    private YourAddressPage yourAddressPage;
    private AddressesPage addressesPage;




    @Given("Page (.*) opened in browser")
        public void pageOpenedInBrowser (String url){


            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);
            homePage = new HomePage(driver);
            logInToYourAccount = new LogInToYourAccount(driver);
            yourAccountPage = new YourAccountPage(driver);
            newAddressPage = new NewAddressPage(driver);
            yourAddressPage = new YourAddressPage(driver);
            addressesPage = new AddressesPage(driver);


        }

        @When("Sign in link clicked on home page")
        public void signInLinkClickedOnHomePage () {

            homePage.clickSignIn();
        }

        @And("email entered in login form email input")
        public void emailEnteredInLoginFormEmailInput () {
            String emailValue = "StephanieRKoon@teleworm.us";
            logInToYourAccount.fillEmailToSignIn(emailValue);
        }

        @And("password entered in login form password input")
        public void passwordEnteredInLoginFormPasswordInput () {
            String passwordValue = "Jacek25";
            logInToYourAccount.fillPasswordToSignIn(passwordValue);
        }

        @And("SignIn button clicked")
        public void signinButtonClicked () {
            logInToYourAccount.clickSignInBtn();
        }


        @And("click addresses btn")
        public void clickAddressesBtn () {
            yourAccountPage.clickAddFirstAddressBtn();
        }

        @And("^click create new address btn$")
        public void clickCreateNewAddressBtn() {
        addressesPage.createNewAddresButton();
    }



        @And("address form filled (.*) (.*) (.*) (.*) (.*) (.*)")
        public void addressFormFilledAliasAddressCityZipPostalCodeCountryPhone (String alias, String address, String
        city,int zipCode, int country, int phone){

            AddressFormData formData = new AddressFormData()
                    .setAlias(alias)
                    .setAddress(address)
                    .setCity(city)
                    .setZipCode(zipCode)
                    .setCountry(country)
                    .setPhoneNumber(phone);
            newAddressPage.funEnterAddressForm(formData);
        }

        @And("click save")
        public void clickSave () {
            newAddressPage.clickSaveBtn();
        }

        @Then("address added")
        public void addressAdded () {
            assertTrue(yourAddressPage.isAddressAddSuccess());
        }

        @Then("delete added address")
        public void deleteAddedAddress () {
            yourAddressPage.deleteAddress();
        }

        @And("check if address is deleted")
        public void checkIfAddressIsDeleted () {
            assertTrue(yourAddressPage.isAddressAddDeleted());

        }

        @And("exit")
        public void exit () {
            driver.close();
        }



}





