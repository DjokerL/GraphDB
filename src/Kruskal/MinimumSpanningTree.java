package Kruskal;
import java.util.*;

public class MinimumSpanningTree {
    private final Graph graph;
    private List<Edge> tree;
    private int[] parent;
    private int weight;

    public MinimumSpanningTree(Graph graph) {
        this.graph = graph;
        this.parent = new int[graph.vertices];
        this.tree = new ArrayList<>();
        MST();
    }

    public int getWeight() {
        return this.weight;
    }

    public void printEdges() {
        System.out.println("source\tdest\tweight");
        tree.forEach(edge -> System.out.println(edge.u + "\t" + edge.v + "\t" + edge.weight + "\n"));
    }

    private void MST() {
        for (int i = 0; i < graph.vertices; i++) {
            makeSet(i);
        }

        Collections.sort(graph.edges);

        for (Edge edge : graph.edges) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.weight;

            if (findSet(u) != findSet(v)) {
                unionSets(u, v);
                weight += w;
                tree.add(edge);
            }
        }
    }

    private void makeSet(int v) {
        parent[v] = v;
    }

    private void unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a != b)
            parent[b] = a;
    }

    private int findSet(int v) {
        if (v == parent[v])
            return v;
        return parent[v] = findSet(parent[v]);
    }

}
