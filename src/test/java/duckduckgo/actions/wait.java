package duckduckgo.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class wait {
    public static Performable waitForElementVisible(Target target) {
        return WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds();
    }
}
