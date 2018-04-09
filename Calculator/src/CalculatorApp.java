import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args){

        String menuContent = "Choose a figure by giving its number \n1.Triangle \n2.Square \n3.Round \n4.Exit";
        Scanner scanner = new Scanner(System.in);
        System.out.println(menuContent);
        try{
            while (true) {
                int choice = scanner.nextInt();
                Print object = null;
                try {
                    switch (choice) {
                        case 1:
                            object = new Triangle();
                            break;
                        case 2:
                            object = new Square();
                            break;
                        case 3:
                            object = new Round();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("There is no such option");
                            break;
                    }
                    if (object != null) {
                        object.print();
                    }
                    pressAnyKeyToContinue();
                    System.out.println(menuContent);
                }
                catch (Exception e) {
                    System.out.println("Wrong data format. Choose a figure one more time:\n1.Triangle \n2.Square \n3.Round \n4.Exit");
                }
            }
        }
        catch(Exception e){
            System.out.println("You choose wrong. Good bye!");
        }
        return;
    }

    static private void pressAnyKeyToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        }
        catch(Exception e) {

        }
    }
}
