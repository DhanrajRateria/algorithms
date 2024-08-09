import java.util.*;
public class dfs {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1, 2));    // Node 0
        adjList.add(Arrays.asList(0, 3, 4)); // Node 1
        adjList.add(Arrays.asList(0, 4));    // Node 2
        adjList.add(Arrays.asList(1, 5));    // Node 3
        adjList.add(Arrays.asList(1, 2, 5)); // Node 4
        adjList.add(Arrays.asList(3, 4)); // Node 5
        int startNode = 0;
        boolean[] visited = new boolean[adjList.size()];
        long startTime = System.nanoTime();
        System.out.print("DFS: ");
        depthFirst(adjList, startNode, visited);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e9;
        System.out.println("\nTime taken: " + elapsedTime + " seconds");
    }

    public static void depthFirst(List<List<Integer>> adjList, int startNode, boolean[] visited) {
        visited[startNode] = true;
        System.out.println(startNode + " ");
        for (int neighbor : adjList.get(startNode)) {
            if (!visited[neighbor]) {
                depthFirst(adjList, neighbor, visited);
            }
        }    
    }
}