package dk.via.exercise14_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.rmi.RemoteException;
import java.util.List;

import static dk.via.exercise14_1.Result.*;
import static org.junit.jupiter.api.Assertions.*;

class WordleGameTest {
    private Dictionary dictionary;

    @BeforeEach
    void setUp() throws RemoteException {
        dictionary = Mockito.mock(Dictionary.class);
    }

    @Test
    void too_short_words_are_not_allowed_as_guesses() throws RemoteException {
        WordleGame game = new WordleGame(5, dictionary);
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCD"));
    }

    @Test
    void too_long_words_are_not_allowed_as_guesses() throws RemoteException {
        WordleGame game = new WordleGame(5, dictionary);
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCDEF"));
    }

    @Test
    void the_server_isnt_called_if_words_have_wrong_length() throws RemoteException {
        WordleGame game = new WordleGame(5, dictionary);
        assertThrows(IllegalArgumentException.class, () -> game.guess("ABCD"));
        Throwable t = assertThrows(IllegalArgumentException.class, () -> game.guess("ABCDEF"));
        assertEquals("Word too long: ABCDEF", t.getMessage());
        Mockito.verify(dictionary, Mockito.never()).lookup(Mockito.anyString());
    }

    @Test
    void unknown_words_are_not_allowed_as_guesses() throws RemoteException {
        Mockito.when(dictionary.lookup(Mockito.anyString())).thenReturn(false);
        WordleGame game = new WordleGame(5, dictionary);
        UnknownWordException exception = assertThrows(UnknownWordException.class, () -> game.guess("CCCCC"));
        assertEquals("CCCCC", exception.getMessage());
    }

    @Test
    void unused_letters_return_as_misses() throws RemoteException {
        Mockito.when(dictionary.randomWord(5)).thenReturn("ABCCD");
        Mockito.when(dictionary.lookup("XXXXX")).thenReturn(true);
        WordleGame game = new WordleGame(5, dictionary);
        assertIterableEquals(List.of(MISS, MISS, MISS, MISS, MISS), game.guess("XXXXX"));
    }

    @Test
    void correct_letters_in_wrong_place_return_as_wrong_place() throws RemoteException {
        Mockito.when(dictionary.randomWord(5)).thenReturn("ABCCD");
        Mockito.when(dictionary.lookup("XABXX")).thenReturn(true);
        WordleGame game = new WordleGame(5, dictionary);
        assertIterableEquals(List.of(MISS, WRONG_PLACE, WRONG_PLACE, MISS, MISS), game.guess("XABXX"));
    }

    @Test
    void correcty_placed_letters_return_as_correct() throws RemoteException {
        Mockito.when(dictionary.randomWord(5)).thenReturn("ABCCD");
        Mockito.when(dictionary.lookup("ABXXX")).thenReturn(true);
        WordleGame game = new WordleGame(5, dictionary);
        assertIterableEquals(List.of(CORRECT, CORRECT, MISS, MISS, MISS), game.guess("ABXXX"));
    }

    @Test
    void correct_overrides_wrong_place() throws RemoteException {
        Mockito.when(dictionary.randomWord(5)).thenReturn("ABCCD");
        Mockito.when(dictionary.lookup("XXXCX")).thenReturn(true);
        WordleGame game = new WordleGame(5, dictionary);
        assertIterableEquals(List.of(MISS, MISS, MISS, CORRECT, MISS), game.guess("XXXCX"));
    }
}
