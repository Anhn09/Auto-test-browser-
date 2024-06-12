package common;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ShareData {
    public static Performable shareDataBetweenActors(String key, Object value) {
        return Task.where(
                "Share data between actors",
                actor -> {
                    Serenity.setSessionVariable(key).to(value);
                }
        );
    }

    public static <T> T getSharedData(Actor actor, String key) {
        return actor.recall(key);
    }
}
