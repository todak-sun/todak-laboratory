package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.function.Function;

public class MapPublisher<T> implements Publisher<T> {

    private final Publisher<T> pub;
    private final Function<T, T> mapper;

    public MapPublisher(Publisher<T> pub, Function<T, T> mapper) {
        this.pub = pub;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
        pub.subscribe(new DeligateSubscriber<T>(subscriber) {
            @Override
            public void onNext(T t) {
                subscriber.onNext(mapper.apply(t));
            }
        });
    }

}
