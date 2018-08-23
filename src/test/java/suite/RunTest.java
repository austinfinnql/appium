package suite;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty" , "html:UpdatePasscode"},
        features = "src/test/resources",
        tags = "@LoginTests",
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        glue ={"steps","config"})

public class RunTest {}
