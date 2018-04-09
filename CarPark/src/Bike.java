import java.util.Scanner;

public class Bike extends Vehicle
        implements IRentable {

    int derailleursAmount;
    boolean hasBoot;

    public Bike(){
        System.out.println("Your choice is a BIKE. Enter your requirements. \nBRAND:");
        Scanner scanner = new Scanner(System.in);
        this.brand = scanner.nextLine();
        System.out.println("\nDERAILLEURS AMOUNT:");
        this.derailleursAmount = scanner.nextInt();
        System.out.println("\nBOOT (TRUE OR FALSE):");
        this.hasBoot = scanner.nextBoolean();
    }

    @Override
    public void rent() {
        System.out.println("\nFor how many days you want to rent this bike?");
        Scanner scanner = new Scanner(System.in);
        this.days = scanner.nextInt();
        if (this.hasBoot)
            System.out.println("\nTHE BIKE YOU RENT FOR " + this.days + " DAYS IS:\n" + this.brand + " WITH " + this.derailleursAmount + " DERAILLEURS WITH A BOOT\n");
        else
            System.out.println("\nTHE BIKE YOU RENT FOR " + this.days + " DAYS IS:\n" + this.brand + " WITH " + this.derailleursAmount + " DERAILLEURS WITHOUT A BOOT\n");
    }

    @Override
    void testDrive() {

    }
}
