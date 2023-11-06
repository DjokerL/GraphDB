package Kruskal;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Edge> edges;
    public int vertices; // number of vertices in graph

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u,v,weight));
    }

}
