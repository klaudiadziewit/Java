import java.util.Scanner;

public class Camper extends Vehicle
        implements IRentable {

    int roomsAmount;
    boolean hasBathroom;

    public Camper(){
        System.out.println("Your choice is a CAMPER. Enter your requirements. \nBRAND:");
        Scanner scanner = new Scanner(System.in);
        this.brand = scanner.nextLine();
        System.out.println("\nROOMS AMOUNT:");
        this.roomsAmount = scanner.nextInt();
        System.out.println("\nBATHROOM (TRUE OR FALSE):");
        this.hasBathroom = scanner.nextBoolean();
    }

    @Override
    public void rent() {
        System.out.println("\nFor how many days you want to rent this camper?");
        Scanner scanner = new Scanner(System.in);
        this.days = scanner.nextInt();
        if (this.hasBathroom)
            System.out.println("\nTHE CAMPER YOU RENT FOR " + this.days + " DAYS IS:\n" + this.brand + " WITH " + this.roomsAmount + " ROOMS WITH A BATHROOM\n");
        else
            System.out.println("\nTHE CAMPER YOU RENT FOR " + this.days + " DAYS IS:\n" + this.brand + " WITH " + this.roomsAmount + " ROOMS WITHOUT BATHROOM\n");
    }

    @Override
    void testDrive() {

    }
}
