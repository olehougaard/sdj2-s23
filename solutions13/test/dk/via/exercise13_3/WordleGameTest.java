package dk.via.exercise13_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.List;

import static dk.via.exercise13_3.Result.*;
import static org.junit.jupiter.api.Assertions.*;

class WordleGameTest {
    private WordleGame game;

    @BeforeEach
    void setUp() throws RemoteException {
        Dictionary dictionary = new FakeRandomDictionary("ABCCD", "XABXX", "XXXXX", "XXXCX", "ABXXX");
        game = new WordleGame(5, dictionary);
    }

    @Test
    void too_short_words_are_not_allowed_as_guesses() throws RemoteException {
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCD"));
    }

    @Test
    void too_long_words_are_not_allowed_as_guesses() throws RemoteException {
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCDEF"));
    }

    @Test
    void unknown_words_are_not_allowed_as_guesses() throws RemoteException {
        UnknownWordException exception = assertThrows(UnknownWordException.class, () -> game.guess("CCCCC"));
        assertEquals("CCCCC", exception.getMessage());
    }

    @Test
    void unused_letters_return_as_misses() throws RemoteException {
        assertIterableEquals(List.of(MISS, MISS, MISS, MISS, MISS), game.guess("XXXXX"));
    }

    @Test
    void correct_letters_in_wrong_place_return_as_wrong_place() throws RemoteException {
        assertIterableEquals(List.of(MISS, WRONG_PLACE, WRONG_PLACE, MISS, MISS), game.guess("XABXX"));
    }

    @Test
    void correcty_placed_letters_return_as_correct() throws RemoteException {
        assertIterableEquals(List.of(CORRECT, CORRECT, MISS, MISS, MISS), game.guess("ABXXX"));
    }

    @Test
    void correct_overrides_wrong_place() throws RemoteException {
        assertIterableEquals(List.of(MISS, MISS, MISS, CORRECT, MISS), game.guess("XXXCX"));
    }
}