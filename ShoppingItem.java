public class ShoppingItem {
    private String name;
    private int quantity;
    private boolean purchased;
    private String category;
    private double price;

    public ShoppingItem(String name, int quantity, String category, double price) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        this.purchased = false;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isPurchased() { return purchased; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void markPurchased() { purchased = true; }

    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return name + "," + quantity + "," + purchased + "," + category + "," + price;
    }

    public static ShoppingItem fromString(String data) {
        String[] p = data.split(",");
        ShoppingItem item = new ShoppingItem(
                p[0], Integer.parseInt(p[1]), p[3], Double.parseDouble(p[4]));
        if (Boolean.parseBoolean(p[2])) item.markPurchased();
        return item;
    }
}
