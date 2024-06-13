package duckduckgo.stepTest;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.Test;

public class TC1 {
    @Steps
    private OpenBrowser openBrowser;
    @Steps
    Search search;
    @Test
    public void TC1(){
        Actor actor1 =  OpenBrowser.open("firefox","Actor 1");
        Actor actor2 =  OpenBrowser.open("chrome","Actor 2");
        Search.searchForThing("red", actor1);
        Search.translateIterm(actor2);
    }
}
