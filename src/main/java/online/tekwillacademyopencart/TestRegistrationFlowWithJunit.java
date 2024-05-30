package online.tekwillacademyopencart;

import online.tekwillacademyopencart.managers.DataGeneratorManager;
import online.tekwillacademyopencart.managers.DriverManager;
import online.tekwillacademyopencart.pageobjects.AccountPage;
import online.tekwillacademyopencart.pageobjects.HomePage;
import online.tekwillacademyopencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import javax.swing.plaf.PanelUI;

public class TestRegistrationFlowWithJunit {
    static WebDriver driver;
        HomePage homePage;
        RegisterPage registerPage;

        @BeforeAll
        public static void  executeOnceBeforeAllTheTest(){
            System.out.println(" The test suite has been started!");
        }

    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Successful registration of a user by using valid credentials")
    public void registerWithValidData() throws InterruptedException {




        String name = DataGeneratorManager.getRandomName();
        String lastname = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword(10,20);
        System.out.println("Email :" + email + " Password " + password);

        registerPage.completeTheRegisterForm(name,lastname, email, password);
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(3000);

        AccountPage accountPage = new AccountPage(driver);

        Assertions.assertTrue(accountPage.isLogoutButtonDisplayed(),"The Logout Button is displayed");
    }
    @Test
    @DisplayName("Unable to register by using invalid password")
    public void registerWithInvalidData() throws InterruptedException {

        String name = DataGeneratorManager.getRandomName();
        String lastname = DataGeneratorManager.getRandomLastName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword(1,10);
        System.out.println("Email :" + email + " Password " + password);

        registerPage.completeTheRegisterForm(name,lastname, email, password);
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("register");
        Assertions.assertTrue(urlContainsRegisterKeyword, " The url contains Register keyword");

    }

    @AfterEach
    public void executeScriptAfterEachTest(){
        DriverManager.getInstance().quitTheDriver();
    }

@AfterAll
    public static void executeTheScriptAfterAllTheSuiteTests(){
        System.out.println("The test suite has been executed ");

    }
}
