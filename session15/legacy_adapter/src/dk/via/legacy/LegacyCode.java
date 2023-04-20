package dk.via.legacy;

import java.util.Dictionary;
import java.util.Enumeration;

public class LegacyCode {
    public LegacyCode() {
    }

    public void printDict(Dictionary dictionary) {
        Enumeration e = dictionary.keys();
        while(e.hasMoreElements()) {
            Object key = e.nextElement();
            Object value = dictionary.get(key);
            System.out.println(key.toString() + "\t" + value.toString());
        }
    }
}
