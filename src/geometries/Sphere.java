package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;

public class Sphere extends Geometry{
    private final Point center;
    private final double radius;

    /**
     * constructor
     * @param center
     * @param radius
     */
    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * prints the sphere type
     * @return
     */
    @Override
    public String toString() {

        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public  Vector getNormal(Point point) {

       Vector p0 = point.subtract(center);
            return p0.normalize();
    }

    /**
     * @param ray
     * @return
     */
    /**@Override
    public List<Point> findIntersections(Ray ray) {
        Point P0 = ray.getP0();
        Vector v = ray.getDir();

        if (P0.equals(center)) {
            return List.of(center.add(v.scale(radius)));
        }

        Vector U = center.subtract(P0);

        double tm = alignZero(v.dotProduct(U));
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

        // no intersections : the ray direction is above the sphere
        if (d >= radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(radius * radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0) {
//            Point P1 = P0.add(v.scale(t1));
//            Point P2 = P0.add(v.scale(t2));
            Point P1 =ray.getPoint(t1);
            Point P2 =ray.getPoint(t2);
            return List.of(P1, P2);
        }
        if (t1 > 0) {
//            Point P1 = P0.add(v.scale(t1));
            Point P1 =ray.getPoint(t1);
            return List.of(P1);
        }
        if (t2 > 0) {
//            Point P2 = P0.add(v.scale(t2));
            Point P2 =ray.getPoint(t2);
            return List.of(P2);
        }
        return null;
    }*/

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray){
        /**List<Point> points=null;
        Point P0 = ray.getP0();
        Vector v = ray.getDir();
        //if the ray is starting from precisely the center of the sphere
        // than we know the intersection point will be scaling the point by the radius
        if (P0.equals(center))
        {
            points=List.of(center.add(v.scale(radius)));
        }

        Vector U = center.subtract(P0); // The vector from p0 to the center of the sphere
        double tm =alignZero(v.dotProduct(U)); // the scalar for the projection of v on u
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm)); // the distance of the center to the ray

        // no intersections : the ray direction is above the sphere
        if (d >= radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(radius * radius - d * d)); // distance from p1 to intersection with d
        double t1 = alignZero(tm - th); // from p0 to p1
        double t2 = alignZero(tm + th);// from p0 to p2

        if (t1 > 0 && t2 > 0) // take only t > 0 (going in the right direction)
        {
//            Point P1 = P0.add(v.scale(t1));
//            Point P2 = P0.add(v.scale(t2));
            Point P1 =ray.getPoint(t1);
            Point P2 =ray.getPoint(t2);
            points= List.of(P1, P2);
        }
        else if (t1 > 0) {
//            Point P1 = P0.add(v.scale(t1));
            Point P1 =ray.getPoint(t1);
            points= List.of(P1);
        }
        else if (t2 > 0) {
//            Point P2 = P0.add(v.scale(t2));
            Point P2 =ray.getPoint(t2);
            points= List.of(P2);
        }

        if(points==null)
            return null;
        else
            return points.stream().map(p->new GeoPoint(this, p)).toList();*/
        Point P0 = ray.getP0();
        Vector v = ray.getDir();

        if (P0.equals(center)) {
            return List.of( new GeoPoint(this,ray.getPoint(radius)));
        }

        Vector U = center.subtract(P0);

        double tm = alignZero(v.dotProduct(U));
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

        // no intersections : the ray direction is above the sphere
        if (d >= radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(radius * radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0) {
//            Point P1 = P0.add(v.scale(t1));
//            Point P2 = P0.add(v.scale(t2));
            Point P1 =ray.getPoint(t1);
            Point P2 =ray.getPoint(t2);
            return List.of(new GeoPoint(this,P1),new GeoPoint(this, P2));
        }
        if (t1 > 0) {
//            Point P1 = P0.add(v.scale(t1));
            Point P1 =ray.getPoint(t1);
            return List.of(new GeoPoint(this,P1));
        }
        if (t2 > 0) {
//            Point P2 = P0.add(v.scale(t2));
            Point P2 =ray.getPoint(t2);
            return List.of(new GeoPoint(this,P2));
        }
        return null;
    }
}

