import java.util.*;

public class dijkstra {
    public static void main(String[] args) {
        int n = 5;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair(10, 1));
        graph.get(0).add(new Pair(5, 3));
        graph.get(1).add(new Pair(1, 2));
        graph.get(1).add(new Pair(2, 3));
        graph.get(2).add(new Pair(4, 4));
        graph.get(3).add(new Pair(2, 1));
        graph.get(3).add(new Pair(9, 2));
        graph.get(3).add(new Pair(2, 4));
        graph.get(4).add(new Pair(6, 0));
        graph.get(4).add(new Pair(7, 2));
        
        int start = 0;
        shortest(graph, start);
    }
    public static class Pair {
        int weight;
        int vertex;

        Pair(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    public static void shortest(List<List<Pair>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(0, start));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            for (Pair edge : graph.get(u)) {
                int v = edge.vertex;
                int wt = edge.weight;
                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    prev[v] = u;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            System.out.println("Vertex: " + i + " - Distance: " + dist[i]);
            System.out.print("Path: ");
            printPath(prev, i);
            System.out.println();
        }
    }
    private static void printPath(int[] prev, int target) {
        if (prev[target] == -1) {
            System.out.print(target);
            return;
        }
        printPath(prev, prev[target]);
        System.out.print(" -> " + target);
    }
}