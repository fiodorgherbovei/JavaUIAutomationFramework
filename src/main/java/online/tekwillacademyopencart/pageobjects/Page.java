package online.tekwillacademyopencart.pageobjects;
import  org.openqa.selenium.WebDriver;
import  org.openqa.selenium.WebElement;
import  org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    protected WebElement userDropDownIcon;

    @FindBy (xpath = "//a[normalize-space()='Register']")
    protected WebElement registerOption;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    protected WebElement loginOption;

    public void navigateToRegisterPage(){
        userDropDownIcon.click();
        registerOption.click();
        System.out.println("The register option was selected from Header ");
    }

public void navigateToLoginPage() {
    userDropDownIcon.click();
    loginOption.click();

}
}
