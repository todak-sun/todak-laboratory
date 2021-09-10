package io.todak.study.laboratory.springjpajts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.geojson.GeoJsonWriter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TEST_POINT")
@Entity
public class TestPoint {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "geometry(POINT)")
    private Point point;

    public double getX() {
        return this.point.getX();
    }

    public double getY() {
        return this.point.getY();
    }

    public String asGeoJson() {

        new GeoJsonWriter()
                .write(this.point);


        return new GeoJsonWriter().write(this.point);
    }

    public TestPoint(double x, double y) {
        this.point = new GeometryFactory().createPoint(new Coordinate(x, y));
    }

    public TestPoint(Point point) {
        this.point = point;
    }
}
