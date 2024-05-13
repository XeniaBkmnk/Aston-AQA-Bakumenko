package by.aston.bakumenko.thirdTask;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Calculation circle = new Circle(10.2, "Red", "Black");
        Calculation rectangle = new Rectangle(5.0, 7.0, "Blue", "Green");
        Calculation triangle = new Triangle(4.0, 6.0, 9.0, "Yellow", "Purple");

        printCalculationInfo(circle);
        printCalculationInfo(rectangle);
        printCalculationInfo(triangle);
    }

    public static void printCalculationInfo(Calculation calculation) {
        System.out.println("Perimeter: " + calculation.getPerimeter());
        System.out.println("Area: " + calculation.getArea());
        System.out.println("Fill Color: " + calculation.getFillColor());
        System.out.println("Border Color: " + calculation.getBorderColor());
        System.out.println();
    }
}