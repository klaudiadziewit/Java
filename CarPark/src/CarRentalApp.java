import java.util.Scanner;

public class CarRentalApp {
    public static void main(String args[]) {
        String menuContent = "Choose your vehicle by giving its number \n1.Bike \n2.Camper \n3.Car \n4.Motorcycle \n5.Exit";
        Scanner scanner = new Scanner(System.in);
        System.out.println(menuContent);

        try {
            while (true) {
                int choice = scanner.nextInt();
                IRentable object = null;
                try {
                    switch (choice) {
                        case 1:
                            object = new Bike();
                            break;
                        case 2:
                            object = new Camper();
                            break;
                        case 3:
                            object = new Car();
                            break;
                        case 4:
                            object = new Motorcycle();
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("There is no such option");
                            break;
                    }
                    if (object != null) {
                        object.rent();
                    }
                    pressAnyKeyToContinue();
                    System.out.println(menuContent);
                } catch (Exception e) {
                    System.out.println("Wrong data format. Choose your vehicle by giving its number \n1.Bike \n2.Camper \n3.Car \n4.Motorcycle \n5.Exit");
                }
            }
        }
        catch (Exception e) {
            System.out.println("You choose wrong. Good bye!");
        }
        return;
    }

    static private void pressAnyKeyToContinue () {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }
}

