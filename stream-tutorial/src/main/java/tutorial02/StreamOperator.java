package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperator {


    public static void main(String[] args) {

        Iterable<Integer> iter = Stream.iterate(1, (n) -> n + 1).limit(1000).collect(Collectors.toList());

        Publisher<Integer> iterPub = new Publisher<>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long l) {
                        try {
                            for (Integer i : iter) {
                                subscriber.onNext(i);
                            }
                        } catch (Exception e) {
                            subscriber.onError(e);
                        }
                        subscriber.onComplete();
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Publisher<String> mapPub = new MapPublisher<>(iterPub, (n) -> String.format("%d * %d = %d", n, n, n * n));
//        Publisher<Integer> sumPub = sumPub(mapPub);
        Publisher<Integer> reducePub = new ReducePublisher<>(mapPub, 1423, (acc, curr) -> acc - curr.length());

        reducePub.subscribe(new LogSubscriber<>());
    }

    private static Publisher<Integer> reducePub(Publisher<Integer> pub, Integer initValue, BiFunction<Integer, Integer, Integer> reducer) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                pub.subscribe(new DeligateSubscriber<Integer, Integer>(subscriber) {
                    int result = initValue;

                    @Override
                    public void onNext(Integer i) {
                        result = reducer.apply(result, i);
                    }

                    @Override
                    public void onComplete() {
                        subscriber.onNext(result);
                        subscriber.onComplete();
                    }
                });
            }
        };
    }

    private static Publisher<Integer> sumPub(Publisher<Integer> pub) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                pub.subscribe(new DeligateSubscriber<Integer, Integer>(subscriber) {
                    int sum = 0;

                    @Override
                    public void onNext(Integer i) {
                        sum += i;
                    }

                    @Override
                    public void onComplete() {
                        subscriber.onNext(sum);
                        subscriber.onComplete();
                    }
                });
            }
        };
    }


}
