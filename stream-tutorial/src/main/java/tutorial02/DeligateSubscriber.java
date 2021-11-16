package tutorial02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeligateSubscriber<T, R> implements Subscriber<T> {

    private Subscriber subscriber;

    public DeligateSubscriber(Subscriber<? super R> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(T t) {
        this.subscriber.onNext(t);
    }

    @Override
    public void onError(Throwable throwable) {
        this.subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        this.subscriber.onComplete();
    }
}
