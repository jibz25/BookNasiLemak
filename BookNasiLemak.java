import java.util.ArrayList;
import java.util.Scanner;

public class BookNasiLemak {
    private static ArrayList<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character left by nextInt()

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    searchAndUpdateOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    displayAllOrders();
                    break;
                case 5:
                    displaySideToppings();
                    break;
                case 6:
                    displayRiceSizes();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void displayMenu() {
    	System.out.println("___________________________");
        System.out.println("\nWelcome To Nasi Lemak JGF");
    	System.out.println("___________________________");
        System.out.println("\nMenu:                      |");
        System.out.println("1. Add Order               |");
        System.out.println("2. Search and Update Order |");
        System.out.println("3. Delete Order            |");
        System.out.println("4. Display All Orders      |");
        System.out.println("5. Display Side Toppings   |");
        System.out.println("6. Display Rice Sizes      |");
        System.out.println("7. Exit                    |");
        System.out.println("___________________________");
    }

    private static void addOrder() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine().trim();
        Customer customer = new Customer(name, phone);

        displaySideToppings();
        System.out.print("Choose side topping: ");
        int sideToppingChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()
        String sideTopping = getSideTopping(sideToppingChoice - 1);

        displayRiceSizes();
        System.out.print("Choose rice size: ");
        int riceSizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()
        String riceSize = getRiceSize(riceSizeChoice - 1);

        int spiceLevel = setSpiceLevel();

        // Create NasiLemak object with chosen options
        NasiLemak nasiLemak = new NasiLemak(sideTopping, riceSize, spiceLevel);

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()

        Order order = new Order(quantity, customer, nasiLemak);
        orders.add(order);

        System.out.println("Order added successfully.");
    }

    private static void searchAndUpdateOrder() {
    System.out.print("Enter customer phone number to search: ");
    String phone = scanner.nextLine().trim();
    Order order = findOrderByPhone(phone);

    if (order != null) {
        System.out.println("Order found. Updating order details.");

        displaySideToppings();
        System.out.print("Choose new side topping: ");
        int sideToppingChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()
        String sideTopping = getSideTopping(sideToppingChoice - 1);

        displayRiceSizes();
        System.out.print("Choose new rice size: ");
        int riceSizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()
        String riceSize = getRiceSize(riceSizeChoice - 1);

        int spiceLevel = setSpiceLevel();

        // Create a new NasiLemak object with updated details
        NasiLemak newNasiLemak = new NasiLemak(sideTopping, riceSize, spiceLevel);
        order.setNasiLemak(newNasiLemak); // Update the order with the new NasiLemak object

        System.out.print("Enter new quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()
        order.setQuantityOrder(newQuantity);

        System.out.println("Order updated successfully.");
    } else {
        System.out.println("Order not found.");
    }
}

    private static void deleteOrder() {
        System.out.print("Enter customer phone number to delete: ");
        String phone = scanner.nextLine().trim();
        Order order = findOrderByPhone(phone);

        if (order != null) {
            orders.remove(order);
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private static void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("\nAll Orders:");
            for (Order order : orders) {
                order.showOrderDetails();
            }
        }
    }

    private static void displaySideToppings() {
        String[] sideToppings = NasiLemak.getSideToppings();
        System.out.println("\nAvailable Side Toppings:");
        for (int i = 0; i < sideToppings.length; i++) {
            System.out.println((i + 1) + ". " + sideToppings[i] + " - RM " + NasiLemak.getSideToppingPrice(sideToppings[i]));
        }
    }

    private static String getSideTopping(int index) {
        String[] sideToppings = NasiLemak.getSideToppings();
        if (index >= 0 && index < sideToppings.length) {
            return sideToppings[index];
        } else {
            return "";
        }
    }

    private static void displayRiceSizes() {
        String[] riceSizes = NasiLemak.getRiceSizes();
        System.out.println("\nAvailable Rice Sizes:");
        for (int i = 0; i < riceSizes.length; i++) {
            System.out.println((i + 1) + ". " + riceSizes[i] + " - RM " + NasiLemak.getRiceSizePrice(riceSizes[i]));
        }
    }

    private static String getRiceSize(int index) {
        String[] riceSizes = NasiLemak.getRiceSizes();
        if (index >= 0 && index < riceSizes.length) {
            return riceSizes[index];
        } else {
            return "";
        }
    }

    private static int setSpiceLevel() {
        System.out.print("Enter spice level (1-5): ");
        int spiceLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()
        return spiceLevel;
    }

    private static Order findOrderByPhone(String phone) {
        for (Order order : orders) {
            if (order.getCustomer().getCustPhoneNumber().equals(phone)) {
                return order;
            }
        }
        return null;
    }
}














