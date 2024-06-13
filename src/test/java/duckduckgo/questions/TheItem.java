package duckduckgo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheItem {
    public static Question<String> getText(Target target) {
        return Text.of(target);
    }

    public static  String getTextByJS(Actor actor, Target target) {
        return actor.asksFor(Evaluate.javascript("return arguments[0].value", target.resolveFor(actor)).result()).toString();
    }
}
