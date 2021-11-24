package io.todak.study.laboratory.designpattern._01_singletone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleSingleTone {

    public static class Property {
        private static final Property property = new Property();

        private Property() {
        }

        public static Property getInstance() {
            return property;
        }
    }

    public static void main(String[] args) {
        Property a = Property.getInstance();
        Property b = Property.getInstance();
        log.info("a == b : {}", a == b);
    }


}
