package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/Features",
glue= {"seleniumgluecode"},
plugin = { "pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
monochrome = true
)

public class testrunner {
	
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    
    }

}
