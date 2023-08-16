package beautiful.reactive.stayreactive.problem01.source;

import beautiful.reactive.stayreactive.model.Item;
import reactor.core.publisher.Mono;

public interface Db {
    static Mono<Item> getItem(int id) {
        return Mono.just(id)
                .map(i -> new Item(id, id, "db " + id));
    }
}
