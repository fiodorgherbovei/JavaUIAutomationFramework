package online.tekwillacademyopencart;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  "src/main/java/online/tekwillacademyopencart/features",
        glue = "online.tekwillacademyopencart.stepdefinitions",
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports"}
)


public class CucumberTestRunner {
}
