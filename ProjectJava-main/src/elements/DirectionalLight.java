package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;



public class DirectionalLight extends Light implements LightSource{

    private Vector _direction;

    /**
     * Ctor of Directional Light
     *
     * @param intensity Intensity of Directional Light
     * @param dir   Direction of the Light - after normalized  -> Not change the current Vector
     */
    public DirectionalLight(Color intensity, Vector dir) {
        super(intensity);
        _direction = dir.normalized();
    }

    /**
     *
     * @param p Point that we want to know the intensity
     * @return Color Intensity
     */
    @Override
    public Color getIntensity(Point3D p) { return super.getIntensity(); }

    /**
     *
     * @param p The Point you want to get Direction
     * @return Vector
     */
    @Override
    public Vector getL(Point3D p) {
        return _direction.normalized();
    }

    @Override
    public double getDistance(Point3D point) {
        return Double.POSITIVE_INFINITY;
    }
}
