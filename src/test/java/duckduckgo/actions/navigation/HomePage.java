package duckduckgo.actions.navigation;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://duckduckgo.com/")
public class HomePage extends PageObject {
    public static final Target BODY =  Target.the("article identifier").locatedBy("//article");
    public static final Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchbox_input");
    public static final Target SEARCH_INPUT = Target.the("search field").locatedBy("//input[@id=\"search_form_input\"]");

}
