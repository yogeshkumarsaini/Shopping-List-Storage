import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingListManager manager = new ShoppingListManager();
        manager.loadFromFile();

        int choice;
        do {
            System.out.println("\n===== SHOPPING LIST MENU =====");
            System.out.println("1. Add Item");
            System.out.println("2. View List");
            System.out.println("3. Search Item");
            System.out.println("4. Edit Quantity");
            System.out.println("5. Sort A–Z");
            System.out.println("6. Show Items by Category");
            System.out.println("7. Delete Purchased Items");
            System.out.println("8. Show Total Item Count");
            System.out.println("9. Show Total Cost");
            System.out.println("10. Save List");
            System.out.println("11. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Item name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Price per item: ");
                    double price = sc.nextDouble();
                    manager.addItem(name, qty, cat, price);
                    break;

                case 2:
                    manager.displayItems();
                    break;

                case 3:
                    System.out.print("Enter search keyword: ");
                    manager.searchItem(sc.nextLine());
                    break;

                case 4:
                    manager.displayItems();
                    System.out.print("Item number: ");
                    int idx = sc.nextInt() - 1;
                    System.out.print("New quantity: ");
                    int newQty = sc.nextInt();
                    manager.editQuantity(idx, newQty);
                    break;

                case 5:
                    manager.sortItems();
                    break;

                case 6:
                    System.out.print("Category name: ");
                    manager.showByCategory(sc.nextLine());
                    break;

                case 7:
                    manager.deletePurchasedItems();
                    break;

                case 8:
                    manager.showTotalItemCount();
                    break;

                case 9:
                    manager.showTotalCost();
                    break;

                case 10:
                    manager.saveToFile();
                    System.out.println("List saved.");
                    break;

                case 11:
                    manager.saveToFile();
                    System.out.println("Goodbye!");
                    break;
            }

        } while (choice != 11);

        sc.close();
    }
}
