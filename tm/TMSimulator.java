package tm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The TMSimulator class simulates a deterministic Turing Machine
 * with a bi-infinite tape. It reads transitions and input from a file.
 * 
 * @author bryce kratzer
 * @author tristan jones
 * @version Spring 2025
 */
public class TMSimulator {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: java tm.TMSimulator <input_file>");
            return;
        }

        // Read input file
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);

        int numStates = scanner.nextInt();
        int numSymbols = scanner.nextInt();
        scanner.nextLine(); // move to next line after reading numbers

        TM tm = new TM(numStates, numSymbols);

        int totalTransitions = (numSymbols + 1) * (numStates - 1);
        for (int i = 0; i < totalTransitions; i++) {
            String[] parts = scanner.nextLine().trim().split(",");
            int nextState = Integer.parseInt(parts[0]);
            int writeSymbol = Integer.parseInt(parts[1]);
            char direction = parts[2].charAt(0);

            int currentState = i / (numSymbols + 1);
            int symbol = i % (numSymbols + 1);

            tm.addTransition(currentState, symbol, new TMTransition(nextState, writeSymbol, direction));
        }

        // Read input string (possibly blank line)
        String input = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        scanner.close();

        // Initialize tape
        Tape tape = new Tape();
        for (char ch : input.toCharArray()) {
            tape.write(Character.getNumericValue(ch));
            tape.moveRight();
        }


        int currentState = tm.getStartState();

        // Run the machine
        while (currentState != tm.getHaltingState()) {
            int currentSymbol = tape.read();
            TMTransition transition = tm.getTransition(currentState, currentSymbol);

            tape.write(transition.getWriteSymbol());

            if (transition.getDirection() == 'R') {
                tape.moveRight();
            } else {
                tape.moveLeft();
            }

            currentState = transition.getNextState();
        }

        // Output result
        System.out.println(tape.getVisitedTape());
    }
}