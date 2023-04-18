package dk.via.exercise13_3;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class FakeRandomDictionary implements Dictionary {
    private final HashSet<String> words;

    public FakeRandomDictionary(String... words) {
        this.words = new LinkedHashSet<>(Arrays.asList(words));
    }

    @Override
    public String randomWord(int length) throws RemoteException {
        return words.stream()
                .filter(w -> w.length() == length)
                .findFirst()
                .orElseThrow(() -> new RemoteException("No words of length " + length));
    }

    @Override
    public boolean lookup(String word) {
        return words.contains(word);
    }
}
