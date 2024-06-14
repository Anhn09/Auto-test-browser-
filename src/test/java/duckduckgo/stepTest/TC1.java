package duckduckgo.stepTest;

import duckduckgo.actions.search.Search;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.Test;

public class TC1 {
    @Test
    public void TC1() throws InterruptedException {
        Actor actor1 =  OpenBrowser.open("firefox","Actor 1");
        Actor actor2 =  OpenBrowser.open("chrome","Actor 2");
        Search.searchForThing("red", actor1);
        Search.translateIterm(actor2);
        Search.searchForThings(actor1);
    }
}
