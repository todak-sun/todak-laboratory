package tutorial03;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FluxScEx2 {


    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(500)) // -> Daemon Thread가 동작하기 때문에, TimeUnit 같은걸 쓰지 않으면 실행이 안되는 것처럼 보임.
                .log()
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }

}
