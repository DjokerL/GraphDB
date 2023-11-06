package Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Node>[] adj;
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int u, int price) {
        adj[v].add(new Node(u,price));
        adj[u].add(new Node(v,price));
    }

}
