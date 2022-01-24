package io.todak.study.laboratory.requsetbodybinding.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping("/")
    public ResponseEntity<?> withCustomConstructor(@RequestBody WithCustomConstructor data) {
        log.info("data : {}", data);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }


    public static class WithCustomConstructor {
        private Long id;
        private String name;
        private String address;

        public WithCustomConstructor(Long id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return "WithCustomConstructor{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

}
