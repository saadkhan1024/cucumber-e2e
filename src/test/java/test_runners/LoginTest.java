package test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {"step_definitions", "hooks"},
        //tags = "not @Skip",
        plugin = {"pretty"}
)
public class LoginTest {
}
