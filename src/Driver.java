import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Store store;

    public Driver() {
 //       processOrder();
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                Shop Menu
                ---------
                   1) Add the clothes
                   2) List the clothes
                   3) List the current clothes
                   4) Delete the clothes in the store
                   5) Search the wanted quality of the cloth
                   0) Exit
                   
                ==>>\s""");

        int option = input.nextInt();
        return option;
    }
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1 -> processOrder();
                case 2 -> printClothes();
                case 3 -> printCurrentCloth();
                case 4 -> deleteCloth();
                case 5 -> searchClothes();
                default -> System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine();

            option = mainMenu();
        }
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
        System.out.print("Please enter the cloth's price:  ");
        String price = input.nextLine();
        System.out.print("Please enter the gender of the wearer:  ");
        String gender = input.nextLine();
        System.out.print("Please enter the suitable temperature of the cloth:  ");
        int temperature = input.nextInt();
        System.out.print("Please enter the suitable height of the cloth:  ");
        double height = input.nextDouble();
        System.out.print("Please enter the suitable weight of the cloth:  ");
        double weight = input.nextDouble();
        System.out.print("Please enter the suitable personality of the cloth:  ");
        String personality = input.nextLine();
        input.nextLine();

        boolean isAdded = store.add(new Cloth(name, price, gender, temperature, height, weight, personality));
        if (isAdded) {
            String str = "Cloth " + name + " added successfully! Total num: " + store.getCount();
            System.out.println(str);
        } else {
            System.out.println("No Cloth Added!");
        }
        if (store.getCount() < store.getSize()) {
            System.out.print("Do you want to add new cloth? (y/n): ");
            char wantToAddNewCloth = input.next().charAt(0);
            boolean bAddNewCloth = false;
            if ((wantToAddNewCloth == 'y') || (wantToAddNewCloth == 'Y'))
                bAddNewCloth = true;

            if (!bAddNewCloth)
                return;
        }
    }
    public void deleteCloth() {
        input.nextLine();
        System.out.println("Do you want to delete the cloth?(y/n): ");
        char wantToDeleteCloth = input.next().charAt(0);
        boolean bDeleteCloth = false;
        if ((wantToDeleteCloth == 'y') || (wantToDeleteCloth == 'Y'))
            bDeleteCloth = true;

        if (!bDeleteCloth)
            return;
        System.out.println("Input the name of the target cloth:");
        input.nextLine();
        String clothName = input.nextLine();
        String result = store.deleteCloth(clothName);
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }
    private void printClothes() {
        System.out.println("List of clothes are:");
        System.out.println(store.listClothes());
    }

    private void printCurrentCloth(){
        System.out.println("Please input the sequence of current cloth: ");
        int iSeq = input.nextInt();
        if (iSeq < 1 || iSeq > store.getCount()) {
            System.out.println("The sequence you input is wrong!");
            return;
        }
        System.out.println("List of CURRENT clothes are:");
        System.out.println(store.listCurrentCloth(iSeq));
    }

    private void searchClothes(){
        input.nextLine();
        System.out.println("Input the string you want to search:");
        String strKey = input.nextLine();
        String strInfo = "Search key is: " + strKey;
        System.out.println(strInfo);
        String strResult = store.searchClothes(strKey);
        System.out.printf("Search result is :%s", strResult);
    }
}
