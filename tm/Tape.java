package tm;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Represents a bi-infinite tape for the Turing Machine using sparse memory.
 * Only stores non-zero (non-blank) cells.
 * 
 * @author Tristan Jones
 * @version Spring 2025
 */
public class Tape {
    private final Map<Integer, Integer> tape = new HashMap<>();
    private int head = 0;

    /**
     * Reads the symbol under the current head position.
     * @return the symbol at the current tape cell, default is 0 (blank)
     */
    public int read() {
        return tape.getOrDefault(head, 0);
    }

    /**
     * Writes a symbol to the current head position.
     * @param value the symbol to write
     */
    public void write(int value) {
        tape.put(head, value);
    }

    /**
     * Moves the head one cell to the left.
     */
    public void moveLeft() {
        head--;
    }

    /**
     * Moves the head one cell to the right.
     */
    public void moveRight() {
        head++;
    }

    /**
     * Returns a string of all visited cells from min to max index (inclusive).
     * @return the contents of the visited tape cells as a string
     */
    public String getVisitedTape() {
        if (tape.isEmpty()) return "";
        int min = Collections.min(tape.keySet());
        int max = Collections.max(tape.keySet());
        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; i++) {
            sb.append(tape.getOrDefault(i, 0));
        }
        return sb.toString();
    }
}