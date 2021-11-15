package tutorial02;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class LogSubscriber<T> implements Subscriber<T> {
    @Override
    public void onSubscribe(Subscription subscription) {
        log.info("onSubscribe");
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        log.info("onNext : {}", t);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("onError", throwable);
    }

    @Override
    public void onComplete() {
        log.info("onComplete");
    }
}
