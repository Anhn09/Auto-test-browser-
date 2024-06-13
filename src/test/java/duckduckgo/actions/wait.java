package duckduckgo.actions;

import net.serenitybdd.screenplay.AnonymousPerformableFunction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class wait {
    public static Performable waitForElementVisible(Target target) {
        return WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds();
    }
    public static AnonymousPerformableFunction waitForPageLoad() {


        return Task.where(
                actor -> {
                    new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(30)).until(
                            (ExpectedCondition<Boolean>) driver -> {
                                assert driver != null;
                                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                            });
                }
        );
    }
}
