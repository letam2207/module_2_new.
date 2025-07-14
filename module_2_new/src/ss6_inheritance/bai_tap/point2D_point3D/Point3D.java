package ss6_inheritance.bai_tap.point2D_point3D;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D (float z,float x, float y) {
        super(x,y);
        this.z = z;
    }
    public Point3D(){
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{getX(), getY(), z};
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        this.z = z;
    }


    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}