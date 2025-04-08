package tm;
import java.util.ArrayList;
import java.util.Map;

import tm.TMState;

/**
 * 
 * @Brycekratzer
 * 
 * The TM class represents a working deterministic Turning Machine
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
     * 
     * @constructor
     */
    public TM(int maxState, int maxChars){
        startState = new TMState(0);
        finalState = new TMState(maxState - 1);
        states = new TMState[maxState];

        // Fill states with id
        for(int i = 0; i < maxState; i++){
            states[i] = new TMState(i);
        }

        // Fill states with 
        for(int i = 0; i < maxChars; i++){
            sigma[i] = i;
        }

    }

    @Override
    public String toString(){
        String output = states + " " + startState;

        return output;
    }
}
