package duckduckgo.stepTest;

import duckduckgo.actions.search.Search;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.jupiter.api.Test;

public class TC1 {
    @Test
    public void TC1() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        Actor actor1 = OpenBrowser.open("firefox", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("actor1"));
        Actor actor2 = OpenBrowser.open("chrome", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("actor2"));

        Search.searchForThing("red", actor1);
        Search.translateIterm(actor2);
        Search.searchForThings(actor1);
    }
}
