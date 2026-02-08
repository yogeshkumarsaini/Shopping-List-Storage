import java.io.*;
import java.util.*;

public class ShoppingListManager {
    private ArrayList<ShoppingItem> items = new ArrayList<>();
    private final String FILE_NAME = "shopping_list.txt";

    public void addItem(String name, int quantity, String category, double price) {
        items.add(new ShoppingItem(name, quantity, category, price));
        System.out.println("Item added!");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Shopping list is empty.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            ShoppingItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() +
                    " (Qty: " + item.getQuantity() + ")" +
                    " Price: ₹" + item.getPrice() +
                    " Total: ₹" + item.getTotalPrice() +
                    " [" + item.getCategory() + "]" +
                    (item.isPurchased() ? " ✔ Purchased" : ""));
        }
    }

    public void searchItem(String keyword) {
        for (ShoppingItem item : items) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(item.getName() + " (Qty: " + item.getQuantity() + ")");
            }
        }
    }

    public void editQuantity(int index, int newQty) {
        if (index >= 0 && index < items.size()) {
            items.get(index).setQuantity(newQty);
            System.out.println("Quantity updated.");
        }
    }

    public void sortItems() {
        items.sort(Comparator.comparing(ShoppingItem::getName));
        System.out.println("Items sorted A–Z.");
    }

    public void showByCategory(String category) {
        for (ShoppingItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item.getName() + " (Qty: " + item.getQuantity() + ")");
            }
        }
    }

    public void deletePurchasedItems() {
        items.removeIf(ShoppingItem::isPurchased);
        System.out.println("Purchased items removed.");
    }

    public void showTotalItemCount() {
        int totalQty = 0;
        for (ShoppingItem item : items) {
            totalQty += item.getQuantity();
        }
        System.out.println("Total items to buy: " + totalQty);
    }

    public void showTotalCost() {
        double total = 0;
        for (ShoppingItem item : items) {
            total += item.getTotalPrice();
        }
        System.out.printf("Total estimated cost: ₹%.2f%n", total);
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (ShoppingItem item : items) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile() {
        items.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(ShoppingItem.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No saved list found.");
        }
    }
}
