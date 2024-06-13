package duckduckgo.stepTest;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class OpenBrowser {
    static OnlineCast theCast = new OnlineCast();

    @Before
    public void setTheStage() {
        OnStage.setTheStage(theCast);
    }

    public static Actor open(String driverType, String stringActorName) {
        return theCast.actorUsingBrowser(driverType).named(stringActorName);
    }
}
