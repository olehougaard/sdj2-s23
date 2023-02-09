package dk.via.pi;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DecimalCache {
    private final ArrayList<BigDecimal> cache;

    public DecimalCache() {
        this.cache = new ArrayList<>();
    }

    public void put(int decimals, BigDecimal piValue) {
        while(cache.size() < decimals + 1) {
            cache.add(null);
        }
        cache.set(decimals, piValue);
    }

    public boolean contains(int decimals) {
        return decimals < cache.size() && cache.get(decimals) != null;
    }

    public BigDecimal get(int decimals) {
        if (decimals < cache.size()) {
            return cache.get(decimals);
        } else {
            return null;
        }
    }
}
