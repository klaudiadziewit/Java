import java.util.Scanner;

public class Car extends Vehicle
    implements IRentable {

    String model;
    int seatAmount;
    double engineCapacity;

    public Car(){
        System.out.println("Your choice is a CAR. Enter your requirements. \nBRAND:");
        Scanner scanner = new Scanner(System.in);
        this.brand = scanner.nextLine();
        System.out.println("\nMODEL:");
        this.model = scanner.nextLine();
        System.out.println("\nSEAT AMOUNT:");
        this.seatAmount = scanner.nextInt();
        System.out.println("\nENGINE CAPACITY:");
        this.engineCapacity = scanner.nextInt();
    }

    @Override
    public void rent() {
        System.out.println("\nFor how many days you want to rent this car?");
        Scanner scanner = new Scanner(System.in);
        this.days = scanner.nextInt();
        System.out.println("\nTHE CAR YOU RENT FOR " + this.days + " DAYS IS\n" + this.brand + " " + this.model + " WITH " + this.seatAmount + " SEATS " + this.engineCapacity + " ENGINE CAPACITY\n");
    }

    @Override
    void testDrive() {

    }
}
