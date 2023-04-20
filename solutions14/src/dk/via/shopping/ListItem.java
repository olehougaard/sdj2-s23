package dk.via.shopping;

import java.util.Objects;

public class ListItem {
    private final String name;
    private final int amount;

    ListItem(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String name() {
        return name;
    }

    public int amount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ListItem) obj;
        return this.name.equals(that.name) && this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        return "ListItem[" +
                "name=" + name + ", " +
                "amount=" + amount + ']';
    }
}
