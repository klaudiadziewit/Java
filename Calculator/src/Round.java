import java.util.Scanner;

public class Round extends Figure
        implements Print {
    private double radius;

    public Round(){
        System.out.print("Your choice is a round.\nradius = ");
        Scanner scanner = new Scanner(System.in);
        this.radius = scanner.nextDouble();
    }

    @Override
    double calculateArea() {
        double roundArea = 3.14 * (this.radius*this.radius);
        return roundArea;
    }

    @Override
    double calculatePerimeter() {
        double roundPerimeter = 2*3.14*this.radius;
        return roundPerimeter;
    }

    @Override
    public void print() {
        if (this.radius > 0) {
            System.out.println("Radius = " + this.radius);
            System.out.println("The Area of your triangle is " + this.calculateArea());
            System.out.println("The Perimeter of your triangle is " + this.calculatePerimeter());
        }
        else
            System.out.println("It cannot be zero!");
    }

}
