package zadanie_pierwsze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInToYourAccount {


        @FindBy(name = "email")
        private WebElement emailInput;
        @FindBy(name = "password")
        private WebElement passwordInput;
        @FindBy(id = "submit-login")
        private WebElement signInButton;

        public LogInToYourAccount(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void fillEmailToSignIn(String emailValue) {
            emailInput.clear();
            emailInput.sendKeys(emailValue);
        }

        public void fillPasswordToSignIn(String passwordValue) {
            passwordInput.clear();
            passwordInput.sendKeys(passwordValue);
        }

        public void clickSignInBtn() {
            signInButton.click();
        }
    }


