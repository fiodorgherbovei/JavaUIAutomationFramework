package online.tekwillacademyopencart;

import online.tekwillacademyopencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://scitl.sfs.md/Pages/Login.aspx");
        //driver.close();

        driver.switchTo().window(currentTabName);
        driver.get("https://www.google.com/webhp?hl=ru&sa=X&ved=0ahUKEwj52v2k5pyGAxVlhP0HHWv9AfEQPAgJ");
        //driver.quit();


    }

}

