package unittests;
import geometries.Polygon;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Primitives.Vector;
import Primitives.point3D;

public class PolygonTest {
    /**
     * Test method for
     */
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0),
                    new point3D(0, 1, 0), new point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }

        // TC02: Wrong vertices order
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(0, 1, 0),
                    new point3D(1, 0, 0), new point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } catch (IllegalArgumentException e) {}

        // TC03: Not in the same plane
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0),
                    new point3D(0, 1, 0), new point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } catch (IllegalArgumentException e) {}

        // TC04: Concave quadrangular
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0),
                    new point3D(0, 1, 0), new point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } catch (IllegalArgumentException e) {}

        // =============== Boundary Values Tests ==================

        // TC10: Vertex on a side of a quadrangular
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0),
                    new point3D(0, 1, 0), new point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } catch (IllegalArgumentException e) {}

        // TC11: Last point = first point
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0),
                    new point3D(0, 1, 0), new point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

        // TC12: Colocated points
        try {
            new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0),
                    new point3D(0, 1, 0), new point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

    }


    @Test
    public void getNormal() {
// ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Polygon pl = null;
        try {
            pl = new Polygon(new point3D(0, 0, 1), new point3D(1, 0, 0), new point3D(0, 1, 0),
                    new point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals(new Vector(sqrt3, sqrt3, sqrt3),
                pl.getNormal(new point3D(0, 0, 1)),
                "Bad normal to Polygon");
    }
}