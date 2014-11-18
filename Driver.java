/* Matthew Bourque
 * COSC 519
 * Semester Project
 *
 * This program is the main driver for the round-robin process scheduling
 * project.
*/

import java.util.*;
import java.io.*;

public class Driver {


    public static void main(String[] args) {

        // Parse agruments
        Object[] arguments = parseArgs(args);
        String processFile = arguments[0].toString();
        String timeQuantum = arguments[1].toString();

        // Read in process list
        List<String> processList = readProcesses(processFile);

        // Read in parameters for each process


        // // Build each process and place in ready queue
        // List<Process> readyQueue = new ArrayList<Process>();
        // for (int i=0; i<numProc; i++) {
        //     Process process = new Process();
        //     process.pid = i+1;
        //     process.burstTime = burstTimes.get(i);
        //     readyQueue.add(process);
        // }

        // Scheduler scheduler = new Scheduler();
        // scheduler.roundRobin(readyQueue, timeQuantum);
    }


    public static Object[] parseArgs(String[] args) {
        /*
         * Parse command line arguments. Return arguments in a list of objects.
        */

        Object[] arguments = new Object[2];
        try {
            arguments[0] = args[0];
            arguments[1] = args[1];
        } catch(Exception e) {
            System.out.println("Missing or invalid command line argument.");
            System.exit(0);
        }

        return arguments;
    }


    public static List<String> readProcesses(String processFile) {
        /*
         * Return a list of processes to execute.
        */

        List<String> processList = new ArrayList<String>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(processFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                processList.add(line);
            }
        } catch(Exception e) {
            System.out.printf("Error reading in file %s", processFile);
        }

        System.out.println(processList.get(1));

        return processList;
    }
}