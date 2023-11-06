package Assignment1;

import java.util.*;
import java.util.stream.IntStream;

public class Company {
    private List<Integer>[] tree;
    private int[] completedTask;
    private Set<Integer> giftedEmployees;
    private Set<Integer> potentialRoots;
    public Company(int employees) {
        this.tree = new ArrayList[employees+1]; // tree[0] will always be empty
        for (int i = 1; i <= employees; i++) {
            this.tree[i] = new ArrayList<>();
        }

        this.giftedEmployees = new HashSet<>();

        this.potentialRoots = IntStream.rangeClosed(1, employees)
                .boxed()
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public void addRelationship(int manager, int subordinate) {
        tree[manager].add(subordinate);
        potentialRoots.remove(subordinate);
    }

    public void addCompletedTaks(int[] tasks) {
        this.completedTask = tasks;
    }

    public void printResult() {
        if (potentialRoots.size() != 1) {
            System.out.println("couldn't print the result, because incoming params are malformed");
            return;
        }
        int root = potentialRoots.iterator().next();
        DFS(root);
        System.out.println("\nnumber of gifted employees is: " + giftedEmployees.size());
        giftedEmployees.forEach(System.out::println);
    }

    private void DFS(int v) {
        if (completedTask[v] == 0) {
            return;
        }
        giftedEmployees.add(v);
        for (int i = 0; i < tree[v].size(); i++) {
            int to = tree[v].get(i);
            DFS(to);
        }
    }
}
