import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;

public class PointTest {

    public static void main(String[] args) {

        Coordinate coordinate = new Coordinate(127.42321, 80.24123);

        CoordinateArraySequence coordinateArraySequence = new CoordinateArraySequence(new Coordinate[]{coordinate});
        PrecisionModel precisionModel = new PrecisionModel();

        GeometryFactory geometryFactory = new GeometryFactory(precisionModel, 4326);

        Point point1 = geometryFactory.createPoint();
        System.out.println(point1);
        Point point = new Point(coordinateArraySequence, geometryFactory);

        System.out.println(point.toText());
    }

}
