import java.util.Scanner;

public class Triangle extends Figure
        implements Print {
    double sideA, sideB, sideC;

    public Triangle() {
        System.out.print("Your choice is a triangle. \na = ");
        Scanner scanner = new Scanner(System.in);
        this.sideA = scanner.nextDouble();
        System.out.print("\nb = ");
        this.sideB = scanner.nextDouble();
        System.out.print("\nc = ");
        this.sideC = scanner.nextDouble();
    }

    @Override
    double calculateArea() {
        double p = (sideA+sideB+sideC)/2;
        double triangleArea=Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
        return triangleArea;
    }

    @Override
    double calculatePerimeter() {
        double trianglePerimeter = this.sideA+this.sideB+this.sideC;
        return trianglePerimeter;
    }

    @Override
    public void print() {
        if (this.sideA > 0 && this.sideB > 0 && this.sideC > 0) {
            System.out.println("Side a = " + this.sideA + "\nSide b = " + this.sideB + "\nSide c = " + this.sideC);
            System.out.println("The Area of your triangle is " + this.calculateArea());
            System.out.println("The Perimeter of your triangle is " + this.calculatePerimeter());
        }
        else
            System.out.println("It cannot be a number below or equals to 0");
        }
}

