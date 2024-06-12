package duckduckgo.stepTest;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class Share {
    @Test
    public void shareData() throws InterruptedException {
        WhenSearchingForTerms.searchForThing("red","firefox","actor 1");
        WhenSearchingForTerms.translateIterm("chrome","actor 2");
        Thread.sleep(10000);
    }
}
