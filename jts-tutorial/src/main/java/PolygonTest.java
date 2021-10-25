import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

public class PolygonTest {

    private Polygon geom;

    public PolygonTest() {
        GeometryFactory factory = new GeometryFactory();
        LinearRing linearRing = factory.createLinearRing();

    }

}
