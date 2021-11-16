package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.function.BiFunction;

public class ReducePublisher<T, R> implements Publisher<R> {

    private final Publisher<T> pub;
    private final R initValue;
    private final BiFunction<R, T, R> reducer;

    public ReducePublisher(Publisher<T> pub, R initValue, BiFunction<R, T, R> reducer) {
        this.pub = pub;
        this.initValue = initValue;
        this.reducer = reducer;
    }


    @Override
    public void subscribe(Subscriber<? super R> subscriber) {
        this.pub.subscribe(new DeligateSubscriber<T, R>(subscriber) {
            private R init = initValue;

            @Override
            public void onNext(T t) {
                init = reducer.apply(init, t);
            }

            @Override
            public void onComplete() {
                subscriber.onNext(init);
                subscriber.onComplete();
            }
        });
    }
}
