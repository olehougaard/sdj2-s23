package dk.via.orders;

import java.math.BigDecimal;

public record Item(String name, BigDecimal price) {
}
