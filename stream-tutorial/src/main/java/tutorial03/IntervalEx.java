package tutorial03;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class IntervalEx {

    public static void main(String[] args) {
        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                int no = 0;
                volatile boolean cancelled = false;

                @Override
                public void request(long n) {
                    log.debug("request - ({})", n);
                    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

                    exec.scheduleAtFixedRate(() -> {
                        if (cancelled) {
                            exec.shutdown();
                            return;
                        }
                        sub.onNext(no++);
                    }, 0, 300, TimeUnit.MILLISECONDS);

                }

                @Override
                public void cancel() {
                    log.debug("cancel");
                    cancelled = true;
                }
            });
        };

        Publisher<Integer> takePub = sub -> {
            pub.subscribe(new Subscriber<Integer>() {

                int count = 0;
                Subscription sbusc;

                @Override
                public void onSubscribe(Subscription subscription) {
                    sbusc = subscription;
                    sub.onSubscribe(subscription);

                }

                @Override
                public void onNext(Integer integer) {
                    sub.onNext(integer);
                    if (++count > 4) {
                        sbusc.cancel();
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    sub.onError(throwable);
                }

                @Override
                public void onComplete() {
                    sub.onComplete();
                }
            });
        };


        takePub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                log.debug("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                log.debug("onNext - ({})", integer);
            }

            @Override
            public void onError(Throwable throwable) {
                log.debug("onError");
            }

            @Override
            public void onComplete() {
                log.debug("onComplete");
            }
        });

    }

}
