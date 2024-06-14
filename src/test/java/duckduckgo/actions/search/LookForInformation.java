package duckduckgo.actions.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LookForInformation {
    public static Performable about(String searchTerm, Target target){
        return Task.where(
                WaitUntil.the(target,isVisible()),
                Enter.theValue(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE).into(target),
                Enter.theValue(searchTerm).into(target).thenHit(Keys.ENTER)
        );
    }
}
