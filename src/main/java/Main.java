import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);

        virusizeMeme(graph, 0);

    }

    public static void virusizeMeme(Graph graph, int startUser) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> sent = new LinkedList<>();
        visited[startUser] = true;
        sent.add(startUser);
        int lastViewer = 0;
        while (!sent.isEmpty()) {
            lastViewer = sent.poll();
            for (int v : graph.nexts(lastViewer)) {
                if(!visited[v]) {
                    visited[v] = true;
                    sent.add(v);
                }
            }
        }
        System.out.println("Последним увидит: " + lastViewer);
    }


}
