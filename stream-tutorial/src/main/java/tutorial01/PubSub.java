package tutorial01;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class PubSub {


    public static void main(String[] args) {

        Iterable<Integer> iter = Stream.iterate(1, (n) -> n + 1).limit(500).collect(Collectors.toList());

        Subscriber<Integer> sub = new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                log.info("onSubscribe");
                subscription.request(10);
            }

            @Override
            public void onNext(Integer i) {
                log.info("onNext : {}", i);
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("onError", throwable);
            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }
        };

        Publisher<Integer> pub = (subscriber) -> subscriber.onSubscribe(new Subscription() {
            private Iterator<Integer> iterator = iter.iterator();
            private long count;

            @Override
            public void request(long l) {
                this.count = l;
                try {
                    while (iterator.hasNext() && count-- > 0) {
                        subscriber.onNext(iterator.next());
                        if(count == 4){
                            throw new RuntimeException("count가 4네?");
                        }
                    }
                } catch (RuntimeException e) {
                    subscriber.onError(e);
                }
                subscriber.onComplete();
            }

            @Override
            public void cancel() {
            }

        });


        pub.subscribe(sub);
    }

}
