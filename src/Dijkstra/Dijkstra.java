package Dijkstra;

import java.util.*;

public class Dijkstra {
    private final Graph graph;
    private int start;
    private int[] distances;

    public Dijkstra(Graph graph, int start) {
        this.graph = graph;
        distances = new int[graph.vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
    }

    private void dijkstra() {
        distances[start] = 0;

        var queue = new PriorityQueue<Pair>();
        for (int i = 0; i < distances.length; i++) {
            queue.add(new Pair(distances[i],i));
        }

        while(!queue.isEmpty()) {
            var front = queue.poll();
            for (var entry : graph.adj[front.vertex]) {
                if (front.cost + entry.price < distances[entry.vertex]) {
                    queue.remove(new Pair(distances[entry.vertex], entry.vertex));
                    distances[entry.vertex] = distances[front.vertex] + entry.price;
                    queue.add(new Pair(distances[entry.vertex], entry.vertex));
                }
            }
        }

    }

    private static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int vertex, int cost)
        {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair compareNode) {
            return this.cost - compareNode.cost;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair other = (Pair) o;
            return vertex == other.vertex && cost == other.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex, cost);
        }
    }

}
