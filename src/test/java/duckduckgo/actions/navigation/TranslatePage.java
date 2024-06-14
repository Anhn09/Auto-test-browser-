package duckduckgo.actions.navigation;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://translate.google.com/?hl=vi&sl=en&tl=vi&op=translate")
public class TranslatePage extends PageObject {
    public static final Target TEXT =  Target.the(" ").locatedBy("//textarea[@aria-label=\"Văn bản nguồn\"]");
    public static final Target TEXT1 =  Target.the(" ").locatedBy("//span[@class='ryNqvb']");
}
