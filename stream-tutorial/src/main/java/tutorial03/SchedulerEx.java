package tutorial03;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.util.CustomizableThreadCreator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Slf4j
public class SchedulerEx {

    public static void main(String[] args) {


        Publisher<Integer> pub = (sub) -> {
            sub.onSubscribe(new Subscription() {
                @Override
                public void request(long l) {
                    log.debug("request({})", l);
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
        //pub

        Publisher<Integer> subOnPub = (sub) -> {
            ExecutorService es = Executors.newSingleThreadExecutor(new CustomizableThreadFactory() {
                @Override
                public String getThreadNamePrefix() {
                    return "subOn-";
                }
            });
            es.execute(() -> pub.subscribe(sub));
            es.shutdown();
        };

        Publisher<Integer> pubOnPub = sub -> {
            subOnPub.subscribe(new Subscriber<>() {
                ExecutorService es = Executors.newSingleThreadExecutor(new CustomizableThreadFactory() {
                    @Override
                    public String getThreadNamePrefix() {
                        return "pubOn-";
                    }
                });

                @Override
                public void onSubscribe(Subscription subscription) {
                    sub.onSubscribe(subscription);
                }

                @Override
                public void onNext(Integer integer) {
                    es.execute(() -> sub.onNext(integer));

                }

                @Override
                public void onError(Throwable throwable) {
                    es.execute(() -> sub.onError(throwable));
                    es.shutdown();
                }

                @Override
                public void onComplete() {
                    es.execute(sub::onComplete);
                    es.shutdown();
                }
            });
        };

        //sub
        pubOnPub.subscribe(new Subscriber<>() {
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

        System.out.println("exit!");

    }


}
