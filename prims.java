import java.util.*;

public class prims {
    public static class Pair {
        int weight;
        int vertex;

        Pair(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair(5, 1));
        graph.get(0).add(new Pair(2, 2));
        graph.get(0).add(new Pair(4, 4));
        graph.get(0).add(new Pair(6, 3));
        graph.get(1).add(new Pair(5, 0));
        graph.get(1).add(new Pair(2, 2));
        graph.get(2).add(new Pair(2, 1));
        graph.get(2).add(new Pair(3, 4));
        graph.get(2).add(new Pair(2, 0));
        graph.get(3).add(new Pair(6, 0));
        graph.get(3).add(new Pair(3, 4));
        graph.get(3).add(new Pair(7, 5));
        graph.get(4).add(new Pair(4, 0));
        graph.get(4).add(new Pair(3, 2));
        graph.get(4).add(new Pair(3, 3));
        graph.get(4).add(new Pair(8, 5));
        graph.get(5).add(new Pair(7, 3));
        graph.get(5).add(new Pair(8, 4));
        prim(graph, 3);
    }

    public static void prim(List<List<Pair>> graph, int start) {
        int n = graph.size();
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] inMST = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        key[start] = 0;
        pq.add(new Pair(0, start));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            if (inMST[u])
                continue;
            inMST[u] = true;

            for (Pair edge : graph.get(u)) {
                int v = edge.vertex;
                int wt = edge.weight;
                if (!inMST[v] && key[v] > wt) {
                    key[v] = wt;
                    parent[v] = u;
                    pq.add(new Pair(wt, v));
                }
            }
        }
        int totalWeight = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] != -1) {
                totalWeight += key[i];
                System.out.println("Edge: " + parent[i] + " - " + i + " Cost: " + key[i]);
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}