package Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    private static class Pair {
        Integer price;
        Integer vertex;

        public Pair(Integer price, Integer vertex) {
            this.price = price;
            this.vertex = vertex;
        }

        public int compareTo(Pair comparePair) {
            return this.price - comparePair.price;
        }

    }

    private final Graph graph;
    private int start;
    private int[] distances;

    public Dijkstra(Graph graph, int start) {
        this.graph = graph;
        distances = new int[graph.vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
    }

    private void dijsktra() {
        distances[start] = 0;
        var queue = new PriorityQueue<Pair>();
        for (int i = 0; i < distances.length; i++) {
            queue.add(new Pair(distances[i],i));
        }
        while(!queue.isEmpty()) {
            var front = queue.poll();
            for (var entry : graph.)
        }

    }

}
