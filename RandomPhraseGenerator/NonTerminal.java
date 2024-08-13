package comprehensive;

import java.util.ArrayList;
import java.util.Random;

public class NonTerminal {
    private ArrayList<Phrase> phrases;
    private Random rng;

    public NonTerminal() {
        phrases = new ArrayList<>();
        rng = new Random();
    }

    public void print() {
        int index = rng.nextInt(phrases.size());
        phrases.get(index).print();
    }

    public void add(Phrase phrase) {
        phrases.add(phrase);
    }
}
