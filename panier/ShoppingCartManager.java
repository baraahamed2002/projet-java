
import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {

        Scanner userIn = new Scanner(System.in);

        String userName;
        String date;

        boolean userQuit = false;

        System.out.println("Welcome to the Shopping Cart!");
        System.out.print("Please enter your name: ");
        userName = userIn.nextLine();
        System.out.print("Please enter the date: ");
        date = userIn.nextLine();

        ShoppingCart sc = new ShoppingCart(userName, date);

        while (!userQuit) {
            int menuChoice = 0;
            System.out.println("\n\nMENU");
            System.out.println("Please select a menu choice:\n"
                    + "\t1. Add item\n"
                    + "\t2. Remove item\n"
                    + "\t3. Modify item\n"
                    + "\t4. Print item descriptions\n"
                    + "\t5. Print shopping cart\n"
                    + "\t6. Quit program\n");
            menuChoice = userIn.nextInt();
            userIn.nextLine();

            String itemName;

            switch (menuChoice) {

                case 1:
                    String name;
                    int price;
                    int quantity;
                    String description;

                    System.out.println("\nADD ITEM TO CART");
                    System.out.println("Enter the item name:");
                    name = userIn.nextLine();
                    System.out.println("Enter the item description:");
                    description = userIn.nextLine();
                    System.out.println("Enter the item price:");
                    price = userIn.nextInt();
                    System.out.println("Enter the item quantity:");
                    quantity = userIn.nextInt();

                    sc.addItem(name, price, quantity, description);
                    break;

                case 2:
                    System.out.println("\nREMOVE ITEM FROM CART");
                    System.out.println("Enter the name of item to remove:");
                    itemName = userIn.nextLine();
                    sc.removeItem(itemName);
                    break;

                case 3:
                    System.out.println("\nMODIFY ITEM IN CART");
                    System.out.println("Enter the name of item to remove:");
                    itemName = userIn.nextLine();
                    sc.modifyItem(itemName, userIn);
                    break;

                case 4:
                    sc.printDescriptions();
                    break;

                case 5:
                    sc.printTotal();
                    break;

                case 6:
                    userQuit = true;
                    break;

                default:
                    System.out.println("\nInvalid input");
                    break;
            }
        }
    }
}
