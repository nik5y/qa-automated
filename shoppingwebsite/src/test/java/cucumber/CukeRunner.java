package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/",
		glue = "stepdef",
		stepNotifications = true,
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html"}
	)
public class CukeRunner {
	
	

}
