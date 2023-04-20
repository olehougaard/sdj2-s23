package dk.via.adapter;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;

public class MapAdapter<K, V> extends Dictionary<K, V> {
    private final Map<K, V> map;

    public MapAdapter(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Enumeration<K> keys() {
        return new IteratorAdapter<>(map.keySet().iterator());
    }

    @Override
    public Enumeration<V> elements() {
        return new IteratorAdapter<>(map.values().iterator());
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }
}
