package Assignment1;

import java.util.*;
import java.util.stream.IntStream;

public class Corporation {
    // Array to represent the hierarchy structure
    private List<Integer>[] hierarchy;
    // Array to store the number of tasks completed by each employee
    public int[] tasksCompletedByEmployee;
    // Set to store the exceptional employees
    private Set<Integer> topPerformers;
    // Set to store potential heads of the corporation
    private Set<Integer> potentialHeads;

    // Constructor to initialize the Corporation with a given number of employees
    public Corporation(int totalEmployees) {
        this.hierarchy = new ArrayList[totalEmployees + 1];
        for (int i = 1; i <= totalEmployees; i++) {
            this.hierarchy[i] = new ArrayList<>();
        }

        this.topPerformers = new HashSet<>();

        potentialHeads = new HashSet<>();
        for (int i = 1; i <= totalEmployees; i++)
            potentialHeads.add(i);
    }

    // Method to establish a manager-subordinate relationship
    public void establishRelationship(int manager, int employee) {
        hierarchy[manager].add(employee);
        // Remove the employee from the potential heads set
        potentialHeads.remove(employee);
    }

    // Method to set the number of tasks completed by each employee
    public void setTasksCompletedByEmployees(int[] tasks) {
        this.tasksCompletedByEmployee = tasks;
    }

    // Method to display the results
    public void displayResults() {
        // Check if there is exactly one potential head to ensure valid input
        if (potentialHeads.size() != 1) {
            System.out.println("Unable to display the results because the input parameters are invalid.");
            return;
        }
        // Get the head of the corporation
        int head = potentialHeads.iterator().next();
        // Start a depth-first traversal of the hierarchy
        traverseHierarchy(head);
        System.out.println("\nNumber of exceptional employees is: " + topPerformers.size());
        // Print the IDs of the exceptional employees
        topPerformers.forEach(System.out::println);
    }

    // Recursive depth-first traversal of the hierarchy
    private void traverseHierarchy(int employee) {
        // If the employee has completed no tasks, return
        if (tasksCompletedByEmployee[employee] == 0) {
            return;
        }
        // Add the employee to the set of top performers
        topPerformers.add(employee);
        // Recursively traverse subordinates
        for (int i = 0; i < hierarchy[employee].size(); i++) {
            int subordinate = hierarchy[employee].get(i);
            traverseHierarchy(subordinate);
        }
    }
}