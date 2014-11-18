import java.util.*;

public class Scheduler {

    public void roundRobin(List<Process> readyQueue, Double timeQuantum) {
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
            if (p.executionTime + timeQuantum <= p.burstTime) {
                System.out.printf("\tExecuting process PID = %s\n", p.pid);
                sleep(convertToMillis(timeQuantum));
                p.executionTime = p.executionTime + timeQuantum;
                readyQueue.remove(0);
            } else if (p.executionTime + timeQuantum > p.burstTime) {
                System.out.printf("\tExecuting process PID = %s\n", p.pid);
                sleep(convertToMillis(timeQuantum - (p.burstTime - p.executionTime)));
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


    private void sleep(int sleepTime) {
        /*
         * Suspend the program execution for the timeQuantum amount.
        */

        try {
            Thread.sleep(sleepTime);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private int convertToMillis(Double timeQuantum) {

        Double timeQuantumMilli = timeQuantum * 1000;
        int sleepTime = timeQuantumMilli.intValue();
        System.out.printf("Sleeping for %d", sleepTime);
        return sleepTime;
    }
}