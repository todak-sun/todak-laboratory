package io.todak.study.laboratory.springjpajts;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TEST_POINT")
@Entity
public class TestPoint {

    @Id
    private Long id;

    private Point point;

}
