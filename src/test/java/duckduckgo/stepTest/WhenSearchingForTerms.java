package duckduckgo.stepTest;

import common.ShareData;
import duckduckgo.actions.navigation.HomePage;
import duckduckgo.actions.navigation.NavigationTo;
import duckduckgo.actions.search.LookForInformation;
import duckduckgo.actions.wait;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class WhenSearchingForTerms {

    static OnlineCast theCast = new OnlineCast();

    @Before
    public void setTheStage() {
        OnStage.setTheStage(theCast);
    }

    public static void searchForThing(String thing, String driverType, String stringActorName) {
        Actor actorName = theCast.actorUsingBrowser(driverType).named(stringActorName);
        Performable shareData = ShareData.shareDataBetweenActors("sharedData", thing);
        actorName.attemptsTo(
                NavigationTo.homePage(),
                LookForInformation.about(thing, HomePage.SEARCH_FIELD),
                wait.waitForElementVisible(HomePage.SEARCH_INPUT),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("red"),
                shareData
        );
    }
    public static void translateIterm(String driverType, String stringActorName) {
        Actor actorName = theCast.actorUsingBrowser(driverType).named(stringActorName);
        String sharedData = ShareData.getSharedData(actorName , "sharedData");
        System.out.println("Shared data: " + sharedData); // Output: Shared data:
        actorName.attemptsTo(
                Open.url("https://translate.google.com/?hl=vi&sl=en&tl=vi&op=translate"),
                LookForInformation.about(sharedData, translate.page.HomePage.TEXT)
        );
    }
}
