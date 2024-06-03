package online.tekwillacademyopencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import online.tekwillacademyopencart.managers.DataGeneratorManager;
import online.tekwillacademyopencart.managers.DriverManager;
import online.tekwillacademyopencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the register form is populated with Valid data")
    public void theRegisterFormIsPopulatedWithValidData() {
        String firstName = DataGeneratorManager.getRandomName();
        String lastName = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword(10,20);

        registerPage.completeTheRegisterForm(firstName,lastName,email,password);
    }

    @And("Privacy Toggle Button is enabled")
    public void privacyToggleButtonIsEnabled() {
        registerPage.enablePrivacyToggle();
    }

    @When("the Continue Button is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnContinueButton();
    }
}
