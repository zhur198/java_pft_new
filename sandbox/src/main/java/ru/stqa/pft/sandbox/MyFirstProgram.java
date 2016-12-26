package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main (String[] args) {
        hello("world");
        hello("user");
        hello("Inna");

        Square s = new Square(5);
        System.out.println("Square with side " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Rectangle with sides " + r.a + " and " + r.b + " = " + r.area());

        Points d = new Points(7, 5, 3, 4);
        System.out.println("Distance between p1 and p2 = " + d.distance());
    }

    public static void hello (String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}