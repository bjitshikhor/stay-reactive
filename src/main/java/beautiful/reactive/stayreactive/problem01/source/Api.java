package beautiful.reactive.stayreactive.problem01.source;

import beautiful.reactive.stayreactive.model.Item;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public interface Api {
    static Flux<Item> getItems(List<Integer> idList) {
        return Flux.fromIterable(idList)
                .delayElements(Duration.ofSeconds(1))
                .map(id -> new Item(id, id, "api " + id));
    }
}
