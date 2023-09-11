package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/CarritoCompra.feature",
        glue = "stepsDefinitions",
        snippets = CAMELCASE
        ,tags= "@realizarCompra")

public class CompraRunner {
}
