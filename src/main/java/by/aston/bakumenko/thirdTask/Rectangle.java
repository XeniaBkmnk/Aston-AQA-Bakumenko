package by.aston.bakumenko.thirdTask;

public class Rectangle implements Calculation {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getArea() {
        return width * height;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}