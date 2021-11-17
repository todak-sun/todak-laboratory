package tutorial02;

import org.reactivestreams.Publisher;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperator {


    public static void main(String[] args) {
        Iterable<Integer> iter = Stream.iterate(1, (n) -> n + 1).limit(1000).collect(Collectors.toList());
        Publisher<Integer> iterPub = new IterablePublisher<>(iter);
        Publisher<String> mapPub = new MapPublisher<>(iterPub, (n) -> String.format("%d * %d = %d", n, n, n * n));
        Publisher<Integer> reducePub = new ReducePublisher<>(mapPub, 1423, (acc, curr) -> acc - curr.length());
//        reducePub.subscribe(new LogSubscriber<>());
        FilterPublisher<Integer> filterPub = new FilterPublisher<>(iterPub, (n) -> n % 2 == 0);
        filterPub.subscribe(new LogSubscriber<>());
    }


}
