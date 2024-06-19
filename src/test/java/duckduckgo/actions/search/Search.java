package duckduckgo.actions.search;

import duckduckgo.actions.navigation.HomePage;
import duckduckgo.actions.navigation.NavigationTo;
import duckduckgo.actions.navigation.TranslatePage;
import duckduckgo.actions.wait;
import duckduckgo.questions.TheItem;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Search {
    public static void searchForThing(String thing, Actor actorName) {
        Serenity.setSessionVariable("shareData").to(thing);

        actorName.attemptsTo(
                NavigationTo.homePage(),
                wait.waitForPageLoad(),
                LookForInformation.about(thing, HomePage.SEARCH_FIELD),
                wait.waitForPageLoad(),
                wait.waitForElementVisible(HomePage.SEARCH_INPUT),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("red")
        );

    }

    public static void translateIterm(Actor actorName) {
        String shareData1 = Serenity.sessionVariableCalled("shareData");

        actorName.attemptsTo(
                NavigationTo.translatePage(),
                WaitUntil.the(TranslatePage.TEXT,isVisible()),
                Enter.theValue(shareData1).into(TranslatePage.TEXT)
        );
        Serenity.setSessionVariable("shareData1").to(TheItem.getTextByJS(actorName, TranslatePage.TEXT1));
    }
    public static void searchForThings(Actor actorName) {
        String shareData1 = Serenity.sessionVariableCalled("shareData1");

        actorName.attemptsTo(
                LookForInformation.about(shareData1,HomePage.SEARCH_INPUT),
                wait.waitForPageLoad(),
                wait.waitForElementVisible(HomePage.SEARCH_INPUT)
        );
    }
}
