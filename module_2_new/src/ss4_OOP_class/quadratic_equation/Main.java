package ss4_OOP_class.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a :");
        double a = scanner.nextDouble();
        System.out.println("Nhập b :");
        double b = scanner.nextDouble();
        System.out.println("Nhập c :");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        if (delta>0){
            System.out.println("Nhiệm 1 :"+quadraticEquation.getRoot1());
            System.out.println("Nhiệm 2 :"+quadraticEquation.getRoot2());
        }else if (delta ==0 ){
            System.out.println("Phương trình có nhiệm kép :"+quadraticEquation.getRoot1() );
        }else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
