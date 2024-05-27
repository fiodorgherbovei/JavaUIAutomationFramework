package online.tekwillacademyopencart.pageobjects;

import online.tekwillacademyopencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "input-email")
    private WebElement userNameInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    public void completeTheLoginForm(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        System.out.println("The Login Form Was Populated with Data");
    }
    public void clickOnContinueButton(){
        ScrollManager.scrollToElement(loginButton);
        loginButton.click();
        System.out.println("The Login Button was clicked");
    }
}
