package online.tekwillacademyopencart.pageobjects;

import online.tekwillacademyopencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends Page{
    public AccountPage(WebDriver driver){
        super(driver);

    }

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logOutButton;

    public void clickOnLogoutButton(){
        ScrollManager.scrollToElement(logOutButton);
        logOutButton.click();
        System.out.println(" The Logout Button was clicked");
    }
}
