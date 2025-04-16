# Project #3: Turing Machine Simulator

* Author: Tristan Jones, Bryce Kratzer  
* Class: CS361 Section 001  
* Semester: Spring 2025

## Overview

This project implements a Turing Machine (TM) simulator that reads the machine configuration and input string from a file, simulates the TM’s behavior using a bi-infinite tape, and prints out the content of visited tape cells upon halting. 

The simulator supports deterministic TMs with a blank symbol (0) and transitions defined for every symbol in every state (except the halting state). The simulation halts once the accepting (halting) state is reached. The tape is implemented using a custom sparse memory approach for efficiency.

## Reflection

The most challenging part of this project was figuring out how to simulate the infinite tape in both directions while keeping it memory-efficient for large simulations. At first, we tried using two deques for left and right halves of the tape, which worked but wasn’t optimal for performance. Switching to a HashMap-based tape model (with the Tape class) drastically improved speed and reduced complexity when handling very large inputs.

To debug, we would log outputs of methods or contents of the hash maps, or toStrings to see that the methods were working. We also used the input files and checked outputs against the expected results manually. 

## Compiling and Using

To run the program, follow these steps:

- Verify you are in the same directory that has the folder:
    * `tm`

- Compile the program using the following command:
    ```bash
    javac tm/*.java
    ```

- Run the simulator on an input file using:
    ```bash
    java tm.TMSimulator <input_file>
    ```

### Example:
```bash
java tm.TMSimulator file5.txt