package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * The TM class represents a deterministic Turing Machine with transitions.
 * It maps (state, symbol) ➝ transition.
 * 
 * @author brycekratzer 
 * @author tristan jones
 * @version Spring 2025
 */
public class TM {
    private final Map<Integer, Map<Integer, TMTransition>> transitions;
    private final int numStates;
    private final int numSymbols;

    public TM(int numStates, int numSymbols) {
        this.numStates = numStates;
        this.numSymbols = numSymbols;
        this.transitions = new HashMap<>();
        for (int state = 0; state < numStates - 1; state++) {
            transitions.put(state, new HashMap<>());
        }
    }

   
    public void addTransition(int currentState, int readSymbol, TMTransition transition) {
        transitions.get(currentState).put(readSymbol, transition);
    }

    public TMTransition getTransition(int state, int symbol) {
        return transitions.get(state).get(symbol);
    }

    public int getHaltingState() {
        return numStates - 1;
    }

    public int getStartState() {
        return 0;
    }
}