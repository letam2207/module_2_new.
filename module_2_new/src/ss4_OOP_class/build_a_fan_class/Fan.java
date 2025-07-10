package ss4_OOP_class.build_a_fan_class;

public class Fan {
    public  final static int SLOW = 1;
    public  final static int MEDIUM = 2;
    public  final static int FAST = 3;

    int speed;
    boolean status;
    double radius;
    String color;

    public Fan() {
        this.speed = SLOW;
        this.status = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        if (status) {
            return "Fan is on: " +
                    "speed = " + speed +
                    ", color = " + color +
                    ", radius = " + radius;
        } else {
            return "Fan is off: " +
                    "color = " + color +
                    ", radius = " + radius;
        }
    }

}
