/* Matthew Bourque
 * COSC 519
 * Semester Project
 *
 * This program is the main driver for the round-robin process scheduling
 * project.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	protected static Scanner userInput = null;
	protected static int MAXIMUM_PID;
	protected static List<Process> readyQueue;
	protected static double timeQuantum = 0.0;
	private static final int MINIMUM_PID = 1;
	private static final int MINIMUM_BURST_TIME = 1;
	private static final int MAXIMUM_BURST_TIME = 10;

	public static void main(String[] args) {

		// Parse agruments

		askUserForInputs(Boolean.TRUE);
		readyQueue = new ArrayList<Process>();
		// Add the process in the readyQueue
		initProcess();

		// Ask User to set the time quantum value

		askUserForInputs(Boolean.FALSE);

		// Schedule the processes
		Scheduler scheduler = new Scheduler();
		scheduler.roundRobin(readyQueue, timeQuantum);
	}

	private static void askUserForInputs(boolean isProcessValueToBeSet) {
		if (isProcessValueToBeSet) {
			System.out
			.println("Please enter the number of Process you want to simulate");
			newScanner();
			evaluateUserInput(Boolean.TRUE);
			closeScanner();
		} else {
			System.out
			.println("Please enter the time Quantum you want to assign");
			newScanner();
			evaluateUserInput(Boolean.FALSE);
			closeScanner();
		}
	}

	private static void closeScanner() {
		userInput.close();
	}

	private static void newScanner() {
		userInput = new Scanner(System.in);
	}

	private static void evaluateUserInput(boolean isProcessNumberSelected) {
		boolean accurateInputsReceived = Boolean.FALSE;
		while (!accurateInputsReceived) {
			if (isProcessNumberSelected) {
				if (userInput.hasNextInt()) {
					MAXIMUM_PID = userInput.nextInt();
					accurateInputsReceived = Boolean.TRUE;
					if (MAXIMUM_PID < 0) {
						System.out
						.println("Please enter the process number atleast more than 5");
						accurateInputsReceived = Boolean.FALSE;
					}
				} else {
					System.out
					.println("Please enter a Positive Integer for the number of Process you want to simulate");
				}
			} else {
				if (userInput.hasNextDouble()) {
					timeQuantum = userInput.nextDouble();
					accurateInputsReceived = Boolean.TRUE;
				} else {
					System.out
					.println("Please enter the Time Quantum value again, for e.g. 2.0 or 4.0");
				}
			}
		}
	}

	private static void initProcess() {
		/*
		 * Instantiate the Ready Queue
		 */
		int counter = MAXIMUM_PID;
		while (counter > -1) {
			int newRandom = getRandomNumber(Boolean.TRUE);
			Process process = instantiateProcess(newRandom);
			readyQueue.add(process);
		}
	}

	private static Process instantiateProcess(int newRandom) {

		Process p = new Process();
		p.pid = String.valueOf(newRandom);
		p.burstTime = getRandomNumber(Boolean.FALSE);
		return p;
	}

	private static int getRandomNumber(boolean generateForPID) {
		Random random = new Random();
		if (generateForPID) {
			return random.nextInt(MAXIMUM_PID - MINIMUM_PID) + MINIMUM_PID;
		} else {
			return random.nextInt(MINIMUM_BURST_TIME - MAXIMUM_BURST_TIME)
					+ MINIMUM_BURST_TIME;
		}
	}

	public static Object[] parseArgs(String[] args) {
		/*
		 * Parse command line arguments. Return arguments in a list of objects.
		 */

		Object[] arguments = new Object[2];
		try {
			arguments[0] = args[0];
			arguments[1] = args[1];
		} catch (Exception e) {
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

		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					processFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				processList.add(line);
			}
		} catch (Exception e) {
			System.out.printf("Error reading in file", processFile);
		}

		return processList;
	}
}