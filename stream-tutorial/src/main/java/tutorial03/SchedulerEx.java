package tutorial03;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class SchedulerEx {

    public static void main(String[] args) {



        Publisher<Integer> pub = (sub) -> {
            sub.onSubscribe(new Subscription() {
                @Override
                public void request(long l) {
                    sub.onNext(1);
                    sub.onNext(2);
                    sub.onNext(3);
                    sub.onNext(4);
                    sub.onNext(5);
                    sub.onComplete();
                }

                @Override
                public void cancel() {

                }
            });
        };


        pub.subscribe(new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                log.debug("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                log.debug("onNext:{}", integer);
            }

            @Override
            public void onError(Throwable throwable) {
                log.debug("onError", throwable);
            }

            @Override
            public void onComplete() {
                log.debug("onComplete");
            }
        });

    }


}
