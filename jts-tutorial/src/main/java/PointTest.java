import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.locationtech.jts.geom.impl.CoordinateArraySequenceFactory;
import org.locationtech.jts.geom.util.GeometryEditor;

public class PointTest {

    public static void main(String[] args) {

        Coordinate coordinate = new Coordinate(127.42321, 80.24123);

        CoordinateArraySequence coordinateArraySequence = new CoordinateArraySequence(new Coordinate[]{coordinate});
        PrecisionModel precisionModel = new PrecisionModel();

        GeometryFactory geometryFactory = new GeometryFactory(precisionModel, 4326);

        CoordinateArraySequenceFactory instance = CoordinateArraySequenceFactory.instance();


        Point point1 = geometryFactory.createPoint(coordinate);
        System.out.println(point1);
        Point point = new Point(coordinateArraySequence, geometryFactory);

        System.out.println(point.toText());
        System.out.println(point.equals(point1));

        //postgresql - postgis와 연동하는 방법 처리 테스트해보기.
    }

}
