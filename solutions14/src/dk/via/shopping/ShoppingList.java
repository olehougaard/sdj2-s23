package dk.via.shopping;

import java.util.ArrayList;

public class ShoppingList {
    private final ArrayList<ListItem> items;
    private double totalCost;

    public ShoppingList() {
        totalCost = 0;
        items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public double totalCost() {
        return totalCost;
    }

    public void addItem(String item, int amount, double price) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount not allowed");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Negative price not allowed");
        }
        if (amount > 0) {
            items.add(new ListItem(item, amount));
            totalCost += amount * price;
        }
    }

    public String getItemName(int index) {
        return items.get(index).name();
    }

    public int getItemAmount(int index) {
        return items.get(index).amount();
    }
}
