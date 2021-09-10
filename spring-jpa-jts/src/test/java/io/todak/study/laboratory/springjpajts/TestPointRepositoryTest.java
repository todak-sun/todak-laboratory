package io.todak.study.laboratory.springjpajts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j
@SpringBootTest
class TestPointRepositoryTest {

    @Autowired
    TestPointRepository testPointRepository;

    @Autowired
    EntityManager em;


    @Rollback(value = false)
    @Test
    public void save_test() {

        TestPoint testPoint = new TestPoint(120.172, 93.12);
        TestPoint save = testPointRepository.save(testPoint);

        Long id = save.getId();

        Optional<TestPoint> founded = testPointRepository.findById(id);

        founded.ifPresent((testPoint1 -> {
            log.info("point : {}, {}, {}", testPoint1.getX(), testPoint1.getY(), testPoint1.asGeoJson());
        }));


    }

}