package logintest_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
// feature-ji konti feature file rum karaychi asel tya feature file cha path ethe put karava
// glue -madhe stepdefination file put karavi name only
// tag-jya kontya tags run kraychya astil tya ethe run karavyaa

 @CucumberOptions(
		features="./src/test/resources/features/login.feature",
		glue = "logintestdef",
		 
//		 features="./src/test/resources/features/parameter.feature",
//			glue = "parameterstepdef",
		tags = "@tag1",
		monochrome = true,
		plugin = {				
				"pretty","html:test-output"
		}
	 		
		)
public class login_test_runner {
	

}
