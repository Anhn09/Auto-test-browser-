package duckduckgo.actions.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigationTo {
    public static Performable homePage(){
        return Task.where(
                Open.browserOn().the(HomePage.class)
        );
    }
}
