package duckduckgo.actions.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class LookForInformation {
    public static Performable about(String searchTerm, Target target){
        return Task.where(
                Enter.theValue(searchTerm).into(target).thenHit(Keys.ENTER)
        );
    }
}
