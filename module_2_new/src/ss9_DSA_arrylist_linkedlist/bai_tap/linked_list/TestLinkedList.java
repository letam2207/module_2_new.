package ss9_DSA_arrylist_linkedlist.bai_tap.linked_list;

import ss9_DSA_arrylist_linkedlist.bai_tap.array_list.TestArrayList;

public class TestLinkedList {
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
        TestArrayList.Student a = new TestArrayList.Student(1, "Huy");
        TestArrayList.Student b = new TestArrayList.Student(2, "Nam");
        TestArrayList.Student c = new TestArrayList.Student(3, "Tâm");
        TestArrayList.Student d = new TestArrayList.Student(4, "Vĩnh");
        TestArrayList.Student e = new TestArrayList.Student(5, "Linh");
        TestArrayList.Student f = new TestArrayList.Student(6, "Long");

        MyLinkedList<TestArrayList.Student> studentMyArrayList = new MyLinkedList<>();

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
