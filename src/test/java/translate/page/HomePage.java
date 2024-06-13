package translate.page;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target TEXT =  Target.the(" ").locatedBy("//textarea[@aria-label=\"Văn bản nguồn\"]");
    public static final Target TEXT1 =  Target.the(" ").locatedBy("//span[@class=\"HwtZe\"]");
}
