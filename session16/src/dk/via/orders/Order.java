package dk.via.orders;

import java.math.BigDecimal;
import java.util.List;

public record Order(Customer customer, List<OrderLine> lines) {
    public BigDecimal total() {
        return lines.stream()
                .map(OrderLine::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
