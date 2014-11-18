public class Process {

    String pid;
    double burstTime;
    double executionTime;
    double waitingTime;
    double turnaroundTime;

    public void Process() {
        /*
         * Constructor method.
        */

        pid = "1";
        burstTime = 0.0;
        executionTime = 0.0;
        waitingTime = 0.0;
        turnaroundTime = 0.0;
    }
}