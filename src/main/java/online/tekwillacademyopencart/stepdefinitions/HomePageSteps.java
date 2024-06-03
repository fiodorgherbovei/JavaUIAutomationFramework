package online.tekwillacademyopencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import online.tekwillacademyopencart.managers.DriverManager;
import online.tekwillacademyopencart.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);



    @Given("The Home Page is accessed")
    public void theHomePageIsAccessed() {
        System.out.println("The cucumber is configured well");
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("RegisterOption is selected from the header drop-down")
    public void registeroptionIsSelectedFromTheHeaderDropDown() {
        homePage.navigateToRegisterPage();

    }
}
