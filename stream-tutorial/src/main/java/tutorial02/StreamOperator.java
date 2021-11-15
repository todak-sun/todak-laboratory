package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperator {


    public static void main(String[] args) {

        Iterable<Integer> iter = Stream.iterate(1, (n) -> n + 1).limit(1000).collect(Collectors.toList());

        var iterPub = new Publisher<Integer>() {
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

        var mapPub = new MapPublisher<Integer>(iterPub, (n) -> n * 2);
        LogSubscriber<Integer> logSub = new LogSubscriber<>();
        mapPub.subscribe(logSub);

    }


}
