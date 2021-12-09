package api.api;

public class Location implements GeoLocation{
    private double x,y,z,distance;

    public Location(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double x() {
        return this.x = x;
    }

    @Override
    public double y() {
        return this.y = y;
    }

    @Override
    public double z() {
        return this.z = z;
    }

    @Override
    public double distance( GeoLocation p) {
        return Math.sqrt(Math.pow(x - p.x(), 2) + Math.pow(y - p.y(), 2) + Math.pow(z - p.z(), 2));
        //3D Destination formula Imported from StackOverFlow.com
    }
}

