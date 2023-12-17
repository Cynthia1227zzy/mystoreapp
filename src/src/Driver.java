package src;

import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Store store;
    public Driver() {
        processOrder();
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                Shop Menu
                ---------
                   1) List the clothes
                   2) List the suitable temperature of the clothes
                   3) List the suitable height of the clothes
                   4) List the suitable weight of the clothes
                   5) List the suitable personality of the clothes
                   0) Exit
                ==>> """);
        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        int option = mainMenu();


        System.out.println("\nPress enter key to continue...");
        input.nextLine();
        input.nextLine();

        option = mainMenu();
    }

    private void processOrder() {

        System.out.print("How many clothes would you like to have in your Store?  ");
        int numberCloth = input.nextInt();

        store = new Store(numberCloth);
        for (int i = 0; i < numberCloth; i++) {
            addCloth();
        }
    }

    private void addCloth() {
        input.nextLine();

        System.out.print("Please enter the cloth's Name:  ");
        String name = input.nextLine();
        System.out.print("Please enter the suitable temperature of the cloth:  ");
        int temperature = input.nextInt();
        System.out.print("Please enter the suitable height of the cloth:  ");
        double height = input.nextDouble();
        System.out.print("Please enter the suitable weight of the cloth:  ");
        double weight = input.nextDouble();
        System.out.print("Please enter the suitable personality of the cloth:  ");
        String personality = input.nextLine();

        System.out.print("Do you want to add new cloth? (y/n): ");
        char wantToAddNewCloth = input.next().charAt(0);
        boolean bAddNewCloth = false;
        if ((wantToAddNewCloth == 'y') || (wantToAddNewCloth == 'Y'))
            bAddNewCloth = true;

        if (!bAddNewCloth)
            return;
        boolean isAdded = store.add(new Cloth(name, temperature, height, weight, personality));
        if (isAdded) {
            System.out.println("Cloth Added Successfully");
        } else {
            System.out.println("No Cloth Added");
        }
    }
}
