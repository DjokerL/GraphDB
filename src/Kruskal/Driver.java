package Kruskal;

public class Driver {
    public static void main(String[] args) {
        var graph = new Graph(5);
        graph.addEdge(1,2,10);
        graph.addEdge(1,4,3);
        graph.addEdge(4,3,5);
        graph.addEdge(2,3,20);
        graph.addEdge(4,2,7);
        graph.addEdge(0,3,100);
        var mst = new MinimumSpanningTree(graph);
        System.out.println(mst.getWeight());
        mst.printEdges();
    }
}
