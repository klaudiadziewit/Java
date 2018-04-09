import java.util.Scanner;

public class Motorcycle extends Vehicle
        implements IRentable {

    float engineCapacity;
    String model;
    boolean hasSidecar;

    public Motorcycle(){
        System.out.println("Your choice is a MOTORCYCLE. Enter your requirements. \nBRAND:");
        Scanner scanner = new Scanner(System.in);
        this.brand = scanner.nextLine();
        System.out.println("\nMODEL:");
        this.model = scanner.nextLine();
        System.out.println("\nSIDECAR (TRUE OR FALSE):");
        this.hasSidecar= scanner.nextBoolean();
        System.out.println("\nENGINE CAPACITY:");
        this.engineCapacity = scanner.nextFloat();
    }

    @Override
    public void rent() {
        System.out.println("\nFor how many days you want to rent this motorcycle?");
        Scanner scanner = new Scanner(System.in);
        this.days = scanner.nextInt();
        if (this.hasSidecar) {
            System.out.println("\nTHE MOTORCYCLE YOU RENT FOR " + this.days + " DAYS IS:\n" + this.brand + " " + this.model + " " + this.engineCapacity + " ENGINE CAPACITY WITH A SIDECAR\n");
        }
        else
            System.out.println("\nTHE MOTORCYCLE YOU RENT FOR " + this.days + " DAYS IS:\n" + this.brand + " " + this.model + " " + this.engineCapacity + " ENGINE CAPACITY WITHOUT SIDECAR\n");
    }

    @Override
    void testDrive() {
        System.out.println("\nIle czasu będzie trwała jazda próbna?");
        Scanner scanner = new Scanner(System.in);
        this.lengthOfTestDrive = scanner.nextFloat();


    }
}
