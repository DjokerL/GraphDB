package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Read the number of employees
        int totalEmployees = inputScanner.nextInt();

        int[] tasksCompleted = new int[totalEmployees + 1];
        for (int i = 1; i < tasksCompleted.length; i++) {
            tasksCompleted[i] = inputScanner.nextInt();
        }

        Corporation company = new Corporation(totalEmployees);
        company.tasksCompletedByEmployee = tasksCompleted;

        // Read and establish manager-subordinate relationships
        for (int i = 1; i < totalEmployees; i++) {
            int manager = inputScanner.nextInt();
            int subordinate = inputScanner.nextInt();
            company.establishRelationship(manager, subordinate);
        }

        // Set the completed tasks in the corporation
        company.setTasksCompletedByEmployees(tasksCompleted);

        // Print the results
        company.displayResults();

        // Close the input scanner
        inputScanner.close();
    }
}