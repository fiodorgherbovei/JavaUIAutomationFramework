package online.tekwillacademyopencart;

import online.tekwillacademyopencart.managers.DataGeneratorManager;
import online.tekwillacademyopencart.managers.DriverManager;
import online.tekwillacademyopencart.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The current url is :" + driver.getCurrentUrl());
        System.out.println("The current page title" + driver.getTitle());

        WebElement userDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        userDropDownIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println("The current url is :" + driver.getCurrentUrl());
        System.out.println("The current page title" + driver.getTitle());

        WebElement firsNameInput = driver.findElement(By.id("input-firstname"));
        firsNameInput.sendKeys("Fiodor");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Gherbovei");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("Email :" + emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("tudor123");

        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement(privacyToggle);
        privacyToggle.click();
        Thread.sleep(4000);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        System.out.println("The current url is :" + driver.getCurrentUrl());
        System.out.println("The current page title" + driver.getTitle());






    }

}

