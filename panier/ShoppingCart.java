
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    private String customerName;
    private String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

    public ShoppingCart() {
        this.customerName = "none";
        this.currentDate = "January 1, 2016";
    }

    public ShoppingCart(String name, String date) {
        this.customerName = name;
        this.currentDate = date;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getDate() {
        return this.currentDate;
    }

    public int getNumItemsInCart() {

        int numItems = 0;
        for (int i = 0; i < cartItems.size(); i++) {

            numItems = numItems + cartItems.get(i).getQuantity();
        }

        return numItems;
    }

    public int getCostOfCart() {

        int total = 0;

        for (int i = 0; i < cartItems.size(); i++) {

            total = total + (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
        }
        return total;
    }

    public void addItem(String name, int price, int quantity, String description) {
        cartItems.add(new ItemToPurchase(name, price, quantity, description));
    }

    public void removeItem(String itemName) {

        boolean foundItem = false;

        for (int i = 0; i < cartItems.size(); i++) {

            if (cartItems.get(i).getName().equals(itemName)) {

                cartItems.remove(i);
                foundItem = true;
            }
        }

        if (!foundItem) {
            System.out.println("\nItem not found in cart");
        }
    }

    public void modifyItem(String itemName, Scanner userIn) {
        boolean foundItem = false;

        int itemIndexNumber = -1;

        for (int i = 0; i < cartItems.size(); i++) {

            if (cartItems.get(i).getName().equals(itemName)) {

                foundItem = true;
                itemIndexNumber = i;
            }
        }

        if (!foundItem) {
            System.out.println("\nItem not found in cart");
            return;
        }

        if (foundItem) {
            int choice = 0;

            System.out.println("\nSelect an attribute to modify:\n"
                    + "\t1. Modify name\n"
                    + "\t2. Modify price\n"
                    + "\t3. Modify quantity\n"
                    + "\t4. Modify description\n");
            choice = userIn.nextInt();
            userIn.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter new item name: ");
                    String name = userIn.nextLine();
                    cartItems.get(itemIndexNumber).setName(name);
                    break;

                case 2:
                    System.out.print("\nEnter new item price: DT");
                    int price = userIn.nextInt();
                    cartItems.get(itemIndexNumber).setPrice(price);
                    break;

                case 3:
                    System.out.print("\nEnter new item quantity: ");
                    int quantity = userIn.nextInt();
                    cartItems.get(itemIndexNumber).setQuantity(quantity);
                    break;

                case 4:
                    System.out.print("\nEnter new item description: ");
                    String description = userIn.nextLine();
                    cartItems.get(itemIndexNumber).setDescription(description);
                    break;

                default:
                    System.out.println("\nInvalid input");
                    break;
            }
        }
    }

    public void printTotal() {
        if (cartItems.size() == 0) {
            System.out.println("\nShopping cart is empty");
        } else {
            System.out.println("\nOUTPUT SHOPPING CART"
                    + "\n" + this.getCustomerName() + "'s Shopping Cart - " + this.getDate()
                    + "\nNumber of Items: " + this.getNumItemsInCart() + "\n");

            for (ItemToPurchase item : cartItems) {
                item.printItemCost();
            }

            System.out.println("\nTotal: DT" + this.getCostOfCart());
        }
    }

    public void printDescriptions() {
        if (cartItems.size() == 0) {
            System.out.println("\nShopping cart is empty");
        } else {
            System.out.println(
                    "\nOUTPUT ITEM DESCRIPTIONS\n" + this.getCustomerName() + "'s Shopping Cart - " + this.getDate()
                            + "\n\nItem Descriptions");

            for (ItemToPurchase item : cartItems) {
                item.printItemDescription();
            }
        }
    }
}
