package tutorial02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public  class IterablePublisher<T> implements Publisher<T> {

        private final Iterable<T> iterable;

        public IterablePublisher(Iterable<T> iterable) {
            this.iterable = iterable;
        }

        @Override
        public void subscribe(Subscriber<? super T> subscriber) {
            subscriber.onSubscribe(new Subscription() {
                private final Iterable<T> iter = iterable;

                @Override
                public void request(long l) {
                    try {
                        for(T item : iter) {
                            subscriber.onNext(item);
                        }
                    } catch (Throwable e){
                        subscriber.onError(e);
                    }
                    subscriber.onComplete();
                }

                @Override
                public void cancel() {

                }
            });
        }
    }