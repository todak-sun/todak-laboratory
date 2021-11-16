package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.function.Function;

public class MapPublisher<T, R> implements Publisher<R> {

    private final Publisher<T> pub;
    private final Function<T, R> mapper;

    public MapPublisher(Publisher<T> pub, Function<T, R> mapper) {
        this.pub = pub;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<? super R> subscriber) {
        pub.subscribe(new DeligateSubscriber<T, R>(subscriber) {
            @Override
            public void onNext(T t) {
                subscriber.onNext(mapper.apply(t));
            }
        });
    }

}
