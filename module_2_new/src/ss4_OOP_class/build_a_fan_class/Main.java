package ss4_OOP_class.build_a_fan_class;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();

        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setStatus(false);

        System.out.println("Fan mặc định:");
        System.out.println(fan);

        System.out.println("\nFan 1:");
        System.out.println(fan1);

        System.out.println("\nFan 2:");
        System.out.println(fan2);
    }

}
