/* Matthew Bourque
 * COSC 519
 * Semester Project
 *
 * This program is the main driver for the round-robin process scheduling
 * project.
*/

import java.util.*;

public class Driver {


    public static void main(String args[]) {

        // Get number of processes
        int numProc = getNumProc();

        // Get time quantum
        double timeQuantum = getTimeQuantum();

        // Get burst times for each process
        List<Double> burstTimes = getBurstTimes(numProc);

        // Build each process and place in ready queue
        List<Process> readyQueue = new ArrayList<Process>();
        for (int i=0; i<numProc; i++) {
            Process process = new Process();
            process.pid = i;
            process.burstTime = burstTimes.get(i);
            readyQueue.add(process);
        }

        // Use round-robin scheduling to execute processes
        while (readyQueue.size() > 0) {

            // Get top process
            Process p = readyQueue.get(0);

            // If the process execution time is less than burst time,
            // then execute the process for a time quantum or until
            // execution time == burst time
            if (p.executionTime + timeQuantum < p.burstTime) {
                p.executionTime = p.executionTime + timeQuantum;
                readyQueue.remove(0);
            } else if (p.executionTime + timeQuantum >= p.burstTime) {
                p.executionTime = p.executionTime + (p.burstTime - p.executionTime);
                readyQueue.remove(0);
            }

            // If execution time is still less than burst time, place
            // process at bottom of ready queue
            if (p.executionTime < p.burstTime) {
                readyQueue.add(p);
            }
        }
    }


    public static List<Double> getBurstTimes(int numProc) {
        /*
         * Return a list containing the burst times for each process
        */

        Scanner keyboard = new Scanner(System.in);
        List<Double> burstTimes = new ArrayList<Double>();
        Double burstTime = 0.0;

        for (int i=0; i<numProc; i++) {

            System.out.printf("Enter burst time for process %d:\n", i+1);

            while (!keyboard.hasNextDouble()) {
                System.out.println("Invalid input.  Please enter a float.");
                keyboard.next();
            }
            burstTime = keyboard.nextDouble();

            burstTimes.add(burstTime);
        }

        return burstTimes;
    }


    public static int getNumProc() {
        /*
         * Return the number of processes as determined by user
        */

        Scanner keyboard = new Scanner(System.in);
        int numProc = 0;

        System.out.println("Enter number of processes:");

        while (!keyboard.hasNextInt()) {
            System.out.println("Invalid input.  Please enter an integer.");
            keyboard.next();
        }
        numProc = keyboard.nextInt();

        return numProc;
    }


    public static double getTimeQuantum() {
        /*
         * Return the time quantum as determined by user
        */

        Scanner keyboard = new Scanner(System.in);
        double timeQuantum = 0.0;

        System.out.println("Enter time quantum:");
        while (!keyboard.hasNextDouble()) {
            System.out.println("Invalid input.  Please enter a float.");
            keyboard.next();
        }
        timeQuantum = keyboard.nextDouble();

        return timeQuantum;
    }
}