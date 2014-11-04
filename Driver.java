/* Matthew Bourque
 * COSC 519
 * Semester Project
 *
 * This program is the main driver for the round-robin process scheduling
 * project.
*/

import java.util.Scanner;

public class Driver {


    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);

        // Get number of processes
        int numProc = 0;
        System.out.println("Enter number of processes:");
        try {
            numProc = keyboard.nextInt();
        } catch(Exception e) {
            System.out.println("Invalid input.  Please enter an integer.");
        }

        // Get time quantum
        double timeQuantum = 0;
        System.out.println("Enter time quantum: ");
        try {
            timeQuantum = keyboard.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input.  Please enter a float.");
        }

        // Build each process and place in ready queue

        // Use round-robin scheduling to execute processes

    }

}