package ss9_DSA_arrylist_linkedlist.bai_tap.array_list;

public class TestArrayList {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Huy");
        Student b = new Student(2, "Nam");
        Student c = new Student(3, "Tâm");
        Student d = new Student(4, "Vĩnh");
        Student e = new Student(5, "Linh");
        Student f = new Student(6, "Long");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();

        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
        studentMyArrayList.add(f);

        studentMyArrayList.remove(4);

        for (int i = 0; i < studentMyArrayList.size(); i++) {
            System.out.println(studentMyArrayList.get(i).getName());
        }

    }
}
