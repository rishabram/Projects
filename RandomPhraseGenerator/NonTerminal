package comprehensive;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a non-terminal in a grammar.
 *
 * @author Rishab Ramalingam and Josh Greenbaum
 * @version 8/1/2024
 */
public class NonTerminal {
    private ArrayList<Phrase> phrases;
    private Random rng;

    /**
     * Constructs a NonTerminal object.
     */
    public NonTerminal() {
        phrases = new ArrayList<>();
        rng = new Random();
    }

    /**
     * Prints a random phrase from the list of phrases.
     */
    public void print() {
        int index = rng.nextInt(phrases.size());
        phrases.get(index).print();
    }

    /**
     * Adds a phrase to the list of phrases.
     *
     * @param phrase the phrase to add
     */
    public void add(Phrase phrase) {
        phrases.add(phrase);
    }
}
