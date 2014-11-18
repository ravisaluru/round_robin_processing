import java.util.*;

public class Scheduler {

    public void roundRobin(List<Process> readyQueue, int timeQuantum) {
        /*
         * Execute the scheduler using Round-Robin Scheduling.
        */

        while (readyQueue.size() > 0) {

            // Get next process
            Process p = readyQueue.get(0);
            System.out.printf("\nLoading process PID = %s\n", p.pid);
            System.out.printf("\tProcess execution time: %f\n", p.executionTime);
            System.out.printf("\tProcess burst time: %f\n", p.burstTime);

            // If the process execution time is less than burst time,
            // then execute the process for a time quantum or until
            // execution time == burst time
            if (p.executionTime + timeQuantum < p.burstTime) {
                System.out.printf("\tExecuting process PID = %s\n", p.pid);
                sleep(timeQuantum);
                p.executionTime = p.executionTime + timeQuantum;
                readyQueue.remove(0);
            } else if (p.executionTime + timeQuantum >= p.burstTime) {
                System.out.printf("\tExecuting process PID = %s\n", p.pid);
                sleep(timeQuantum);
                p.executionTime = p.executionTime + (p.burstTime - p.executionTime);
                readyQueue.remove(0);
            }

            // If execution time is still less than burst time, place
            // process at beginning of ready queue
            if (p.executionTime < p.burstTime) {
                readyQueue.add(p);
            }
        }
    }


    private void sleep(int timeQuantum) {
        /*
         * Suspend the program execution for the timeQuantum amount.
        */

        try {
            Thread.sleep(timeQuantum * 1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}