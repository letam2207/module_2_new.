package ss5_accessmodifier_static_method.bai_tap.build_class_write_in;

public class Test {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Tâm");
        student.setClasses("C05");
        System.out.println("Tên : "+student.getName());
        System.out.println("Lớp : "+student.getClasses());

    }
}
