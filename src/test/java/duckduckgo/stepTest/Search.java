package duckduckgo.stepTest;

import duckduckgo.actions.navigation.HomePage;
import duckduckgo.actions.navigation.NavigationTo;
import duckduckgo.actions.search.LookForInformation;
import duckduckgo.actions.wait;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

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
        System.out.println("======================="+shareData1);

        actorName.attemptsTo(
                Open.url("https://translate.google.com/?hl=vi&sl=en&tl=vi&op=translate"),
                Enter.theValue(shareData1).into(translate.page.HomePage.TEXT)
        );
        Serenity.setSessionVariable("shareData").to(Text.of(translate.page.HomePage.TEXT1));
        System.out.println(Text.of(translate.page.HomePage.TEXT1).toString());
//        String shareData2 = Serenity.sessionVariableCalled("shareData");
//        System.out.println("======================="+shareData2);
    }
}
