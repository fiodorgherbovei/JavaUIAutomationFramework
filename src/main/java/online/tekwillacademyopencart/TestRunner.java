package online.tekwillacademyopencart;
import online.tekwillacademyopencart.managers.DataGeneratorManager;
import online.tekwillacademyopencart.managers.DriverManager;
import online.tekwillacademyopencart.pageobjects.AccountPage;
import online.tekwillacademyopencart.pageobjects.RegisterPage;
import online.tekwillacademyopencart.pageobjects.HomePage;
import online.tekwillacademyopencart.pageobjects.LoginPage;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickOnContinueButton();
        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Fedot","Talcovii",randomEmail,"tudorel123");
        Thread.sleep(3000);

        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(3000);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnLogoutButton();

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeTheLoginForm(randomEmail,"tudorel123");
        loginPage.clickOnContinueButton();

        driver.quit();
        System.out.println("The Test is finished and the driver is closed");

    }

}

