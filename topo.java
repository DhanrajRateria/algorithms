import java.util.*;

public class topo {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        List<Integer> result = topoS(V, adj);
        System.out.print("Topological Sort: ");
        for (int v : result) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void dfs(int v, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, stack);
            }
        }
        stack.push(v);
    }

    public static List<Integer> topoS(int V, List<List<Integer>> adjList) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}