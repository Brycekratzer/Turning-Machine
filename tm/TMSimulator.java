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


        // TODO:
        // For each state received on the first line, 
        // we need to account for each character, specified on the second line, transition.


        // Each state will always have a transition for each character, EXCEPT the last state. 
        // The LAST STATE, DOES NOT, have ANY EXITING TRANSITIONS

        // Initializing the Turning Machine by getting the number of states and characters
        try(Scanner fileReader = new Scanner(new File(filePath))) {
            String line = fileReader.nextLine();
            numStates = Integer.parseInt(line);
            line = fileReader.nextLine();
            numChars = Integer.parseInt(line);
            tm = new TM(numStates, numChars);
    
            // Initialzing the state transitions
            int lineIndex = 0;
            int transitionsPerState = numChars + 1;
            int totalTransitions = (numStates - 1) * (numChars + 1);
            while (fileReader.hasNextLine()){
                String transitionline = fileReader.nextLine();
    
                // Get each part from line
                String[] parts = line.split(",");
    
                // Calculate current state and index
                int currentStateIndex = lineIndex / transitionsPerState;
                int currentCharIndex = lineIndex % transitionsPerState;
    
                // Get parts from line
                int nextState = Integer.parseInt(parts[0]);
                int writeChar = parts[1].charAt(0);
                int moveDirection = parts[2].charAt(0) == 'R' ? 1 : 0;

                tm.addState()
    
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
