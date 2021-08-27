package zadanie_pierwsze;




import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/resources/Features/addAddress.feature")
@RunWith(Cucumber.class)
public class RunCucumberTest {
}
