package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.function.Predicate;

public class FilterPublisher<T> implements Publisher<T> {

    private final Publisher<T> pub;
    private final Predicate<T> predictor;

    public FilterPublisher(Publisher<T> pub, Predicate<T> predictor) {
        this.pub = pub;
        this.predictor = predictor;
    }

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
        pub.subscribe(new DeligateSubscriber<T, T>(subscriber) {
            @Override
            public void onNext(T t) {
                if(predictor.test(t)){
                    subscriber.onNext(t);
                }
            }
        });
    }
}
