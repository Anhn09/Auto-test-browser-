package duckduckgo.stepTest;

import duckduckgo.actions.navigation.HomePage;
import duckduckgo.actions.navigation.NavigationTo;
import duckduckgo.actions.search.LookForInformation;
import duckduckgo.actions.wait;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenSearchingForTerms {
    OnlineCast theCast = new OnlineCast();
    @Before
    public void setTheStage() {
        OnStage.setTheStage(theCast);
    }
    @Test
    public void searchForThing() {
        Actor actor1 = theCast.actorUsingBrowser("firefox").named("actor 1");
        Actor actor2 = theCast.actorUsingBrowser("chrome").named("actor 2");
        actor1.attemptsTo(
                NavigationTo.homePage(),
                LookForInformation.about("red", HomePage.SEARCH_FIELD),
                wait.waitForElementVisible(HomePage.SEARCH_INPUT),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("red")
        );

        actor2.attemptsTo(
                Open.url("https://translate.google.com/?hl=vi&sl=en&tl=vi&op=translate")
        );
    }
}
