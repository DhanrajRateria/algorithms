import java.util.*;
public class bfs {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1, 2));    // Node 0
        adjList.add(Arrays.asList(0, 3, 4)); // Node 1
        adjList.add(Arrays.asList(0, 4));    // Node 2
        adjList.add(Arrays.asList(1, 5));    // Node 3
        adjList.add(Arrays.asList(1, 2, 5)); // Node 4
        adjList.add(Arrays.asList(3, 4));    // Node 5

        int startNode = 0;
        boolean[] visited = new boolean[adjList.size()];

        long startTime = System.nanoTime();
        System.out.print("BFS: ");
        breadthFirst(adjList, startNode, visited);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e9;
        System.out.println("\nTime taken: " + elapsedTime + " seconds");
    }

    public static void breadthFirst(List<List<Integer>> adjList, int startNode, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + " ");
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}