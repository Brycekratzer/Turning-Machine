package tm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tm.TMState;

/**
 * The TM class represents a working deterministic Turning Machine
 * 
 * @author brycekratzer
 */
class TM {
    private TMState[] states;
    private int[] sigma;
    private TMState startState;
    private TMState finalState;

    /* Visual of the Data Structure
     * 
     * current State |   Transitions
     * TMState       ->  ( nextState -> [element to write ,  int[ element to write , shift Left (0), Right (1) ] ) ,
     *                   ( nextState -> [element to write ,  int[ element to write , shift Left (0), Right (1) ] )
     * 
     * TMState       ->  ( nextState -> [element to write ,  int[ element to write , shift Left (0), Right (1) ] ) ,
     *                   ( nextState -> [element to write ,  int[ element to write , shift Left (0), Right (1) ] )
     */
    private Map<TMState, Map<TMState, int[]>> transitions;


    /**
     * @constructor
     * 
     * Creates a new turning machine, filling in each state based on the size, and symbols based on the number
     * of symbols specified
     */
    public TM(int maxState, int maxChars){
        startState = new TMState(0);
        finalState = new TMState(maxState - 1);
        states = new TMState[maxState];
        sigma = new int[maxChars + 1];
        transitions = new HashMap<>();

        // Fill states with id
        for(int i = 0; i < maxState; i++){
            states[i] = new TMState(i);
        }

        // Fill symbols with integers
        for(int i = 0; i <= maxChars; i++){
            sigma[i] = i;
        }

    }

    /**
     * Adds a transition to our turning machine based on the current state specified, the next state, 
     * and other transition info
     * 
     * @param currentState - Source State 
     * @param nextState - Destination state
     * @param transitionSym - What is written to tape
     * @param moveDirection - Which direction we move on tape after writing to the tape
     */
    public void addTransition(TMState currentState, TMState nextState, int writeSym, int moveDirection){
        int[] transitionInfo = {writeSym, moveDirection};
        
        // Check if the inner map exists, create it if not
        if (!transitions.containsKey(currentState)) {
            transitions.put(currentState, new HashMap<>());
        }
        
        transitions.get(currentState).put(nextState, transitionInfo);
    }

    @Override
    public String toString() {
        String output = "";
        for(TMState currentState : transitions.keySet()) {
            output += "From State: " + currentState.toString();
            Map<TMState, int[]> stateTransitions = transitions.get(currentState);
            for(TMState nextState : stateTransitions.keySet()) {
                int[] transitionInfo = stateTransitions.get(nextState);
                output += "  To State: " + nextState.toString() +
                          "  Write: " + transitionInfo[0] +
                          "  Move: " + (transitionInfo[1] == 1 ? "Right" : "Left") + "\n";
            }
        }
        return output;
    }
}
