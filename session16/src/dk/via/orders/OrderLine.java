package dk.via.orders;

import java.math.BigDecimal;

public record OrderLine(Item item, int quantity) {
    public BigDecimal price() {
        return item.price().multiply(BigDecimal.valueOf(quantity));
    }
}
