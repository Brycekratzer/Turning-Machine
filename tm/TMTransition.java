package tm;


/**
 * Represents a transition in the Turing Machine.
 * Holds the next state, the symbol to write, and the movement direction.
 * 
 * @author Tristan Jones
 * @version Spring 2025
 */
public class TMTransition {
    private final int nextState;
    private final int writeSymbol;
    private final char direction; // 'L' or 'R'

    public TMTransition(int nextState, int writeSymbol, char direction) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
    }

    /**
     * 
     * @return number representing the state
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * 
     * @return a number representing the write symbol
     */
    public int getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * 
     * @return returns the character for what direction to move
     */
    public char getDirection() {
        return direction;
    }
}