import java.util.Scanner;

public class Square extends Figure
        implements Print {
    double side;

    public Square(){
        System.out.print("Your choice is a square. \na = ");
        Scanner scanner = new Scanner(System.in);
        this.side = scanner.nextDouble();
    }

    @Override
    double calculateArea() {
        double squareArea = this.side * this.side;
        return squareArea;
    }

    @Override
    double calculatePerimeter() {
        double squarePerimeter=4*this.side;
        return squarePerimeter;
    }

    @Override
    public void print() {
        if (this.side > 0) {
            System.out.println("Side a = " + this.side);
            System.out.println("The Area of your triangle is " + this.calculateArea());
            System.out.println("The Perimeter of your triangle is " + this.calculatePerimeter());
        }
        else
            System.out.println("It cannot be a number below or equals to 0");
    }
}
