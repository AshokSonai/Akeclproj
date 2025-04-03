
package aklog;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = {"src/test/java/akcucu/locuc.feature"},
    glue = "steps",
    snippets = SnippetType.CAMELCASE,
    monochrome = true,
    dryRun = false // Explicitly set to false
)
public class Runner extends AbstractTestNGCucumberTests {

 @Override@DataProvider(parallel = true)
 public Object[][] scenarios() 
 {        
	 return super.scenarios();    
 } 
 }
