package dk.via.exercise14_1;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static dk.via.exercise14_1.Result.*;

public class WordleGame {
    private final int wordLength;
    private final Dictionary dictionary;
    private final String target;

    public WordleGame(int wordLength, Dictionary dictionary) throws RemoteException {
        this.wordLength = wordLength;
        this.dictionary = dictionary;
        target = dictionary.randomWord(wordLength);
    }

    public List<Result> guess(String userGuess) throws RemoteException {
        if (userGuess.length() < wordLength) throw new IllegalArgumentException("Word too short: " + userGuess);
        if (userGuess.length() > wordLength) throw new IllegalArgumentException("Word too long: " + userGuess);
        if (!dictionary.lookup(userGuess)) throw new UnknownWordException(userGuess);
        ArrayList<Result> result = new ArrayList<>();
        for(int i = 0; i < userGuess.length(); i++) {
            result.add(checkLetter(i, userGuess.charAt(i)));
        }
        return result;
    }

    private Result checkLetter(int i, char c) {
        if (target.charAt(i) == c) return CORRECT;
        if (target.contains(String.valueOf(c))) return WRONG_PLACE;
        return MISS;
    }
}
