package beautiful.reactive.stayreactive.problem01;

import beautiful.reactive.stayreactive.model.Item;
import beautiful.reactive.stayreactive.problem01.source.Api;
import beautiful.reactive.stayreactive.problem01.source.Db;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> idList = Arrays.asList(1, 2, 3, 1, 5, 4, 2, 8, 10, 2);
        Map<Integer, List<Integer>> itemIdIndexMap = new HashMap<>();
        for (int i = 0; i < idList.size(); i++)
            itemIdIndexMap.computeIfAbsent(idList.get(i), id -> new ArrayList<>()).add(i);

        List<Item> response = new ArrayList<>(Collections.nCopies(idList.size(), null));
        Flux<Item> responseFlux = Flux.fromIterable(idList).distinct()
                .collect(Collectors.partitioningBy(id -> id % 2 == 0))
                .flatMapMany(map -> {
                    Flux<Item> itemFlux = Flux.empty();

                    List<Integer> evenIdList = map.get(true);
                    itemFlux = itemFlux.concatWith(Api.getItems(evenIdList));

                    List<Integer> oddIdList = map.get(false);
                    itemFlux = itemFlux.concatWith(Flux.fromIterable(oddIdList).flatMap(Db::getItem));

                    return itemFlux;
                })
                .doOnNext(item -> itemIdIndexMap.get(item.getItemId())
                        .forEach(index -> response.set(index, item))
                )
                .thenMany(Flux.fromIterable(response));
        responseFlux.subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
