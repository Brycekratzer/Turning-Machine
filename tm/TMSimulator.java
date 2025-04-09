package tm;
import tm.TM;
import tm.TMState;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMSimulator{
    public static void main(String[] args) {
        String filePath = args[0];
        TM tm; 
        int numStates;
        int numChars;

        /* READING FILE INFO 
         * 
         * First line of file is the number of states
         * Second line is the number of characters
         * The proceeding lines represent a transition.
         * There will be n + 1 transitions per state besides the last state, where n is the number of characters.
         * 
         * Each state will always have a transition for each character, EXCEPT the last state. 
         * The LAST STATE DOES NOT have ANY EXITING TRANSITIONS.
         * 
         */

        // Initializing the Turning Machine by getting the number of states and characters
        try(Scanner fileReader = new Scanner(new File(filePath))) {

            /* Grabbing the number of states and number of symbols from the first 2 lines */
            String line = fileReader.nextLine();
            numStates = Integer.parseInt(line);
            line = fileReader.nextLine();
            numChars = Integer.parseInt(line);
            tm = new TM(numStates, numChars);
    
            /* Variables for properly adding transitions */
            int lineIndex = 0;
            int transitionsPerState = numChars + 1;

            /* Looping through every transition based on what line we are reading in the file */
            while (fileReader.hasNextLine()){
                String transitionline = fileReader.nextLine();
    
                // Get each part from line
                String[] parts = transitionline.split(",");
    
                // Calculate current state and index
                int currentStateIndex = lineIndex / transitionsPerState;

                // Create a new state to add to the Turning machine based on the index.
                TMState state = new TMState(currentStateIndex);
    
                // Get next state for transition
                int nextStateID = Integer.parseInt(parts[0]);
                TMState nextState = new TMState(nextStateID);

                // Get other info needed for transition
                int writeChar = Integer.parseInt(parts[1]);
                int moveDirection = parts[2].charAt(0) == 'R' ? 1 : 0;

                lineIndex++;

                // Add transition to our turning machine
                tm.addTransition(state, nextState, writeChar, moveDirection);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
