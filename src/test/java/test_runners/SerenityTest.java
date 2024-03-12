package test_runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/AccountInformation.feature"},
        glue = {"step_definitions", "hooks"},
        plugin = {"pretty"}
)
public class SerenityTest {
}
