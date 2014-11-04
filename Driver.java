/* Matthew Bourque
 * COSC 519
 * Semester Project
 *
 * This program is the main driver for the round-robin process scheduling
 * project.
*/

import java.util.*;

public class Driver {


    public static int getNumProc() {
        /*
         * Return the number of processes as determined by user
        */

        Scanner keyboard = new Scanner(System.in);
        int numProc = 0;

        System.out.println("Enter number of processes:");
        try {
            numProc = keyboard.nextInt();
        } catch(Exception e) {
            System.out.println("Invalid input.  Please enter an integer.");
        }

        return numProc;
    }


    public static double getTimeQuantum() {
        /*
         * Return the time quantum as determined by user
        */

        Scanner keyboard = new Scanner(System.in);
        double timeQuantum = 0.0;

        System.out.println("Enter time quantum:");
        try {
            timeQuantum = keyboard.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input.  Please enter a float.");
        }

        return timeQuantum;
    }


    public static void main(String args[]) {

        // Get number of processes
        int numProc = getNumProc();

        // Get time quantum
        double timeQuantum = getTimeQuantum();

        // Build each process and place in ready queue
        List<Process> readyQueue = new ArrayList<Process>();
        for (int i=0; i<numProc; i++) {
            Process p = new Process();
            readyQueue.add(p);
        }


        // Use round-robin scheduling to execute processes

    }

}