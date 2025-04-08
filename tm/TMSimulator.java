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


        // TODO:
        // For each state received on the first line, 
        // we need to account for each character, specified on the second line, transition.

        
        // Each state will always have a transition for each character, EXCEPT the last state. 
        // The LAST STATE, DOES NOT, have ANY EXITING TRANSITIONS

        try(Scanner fileReader = new Scanner(new File(filePath))) {
            int lineIndex = 0;
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();

                // Getting the number of states for 
                if (lineIndex == 0){
                    tm = new TM(Integer.parseInt(line));
                }

                // 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
