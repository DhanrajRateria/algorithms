public class knapsack {
    public static void main(String[] args) {
        int W = 50;
        int[] wt = { 10, 20, 50 };
        int[] val = { 30, 100, 120 };
        System.out.println("Max value: " + ks(W, wt, val));
    }

    public static int ks(int max, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n][max + 1];
        for (int j = 0; j <= max; j++) {
            if (weights[0] <= j) {
                dp[0][j] = values[0];
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (weights[i] <= j) {
                    take = dp[i - 1][j - weights[i]] + values[i];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        System.out.println("DP Table:");
        printDPTable(dp);
        int[] selectedItems = findSelectedItems(dp, weights, values, max);
        System.out.println("Selected items (0/1 format):");
        for (int item : selectedItems) {
            System.out.print(item + " ");
        }
        System.out.println();

        return dp[n - 1][max];
    }

    private static void printDPTable(int[][] dp) {
        for (int[] row : dp) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int[] findSelectedItems(int[][] dp, int[] weights, int[] values, int max) {
        int n = weights.length;
        int w = max;
        int totalWeight = 0;
        int totalValue = 0;
        int[] selectedItems = new int[n];
        System.out.println("Selected items (index: weight, value):");
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0 && dp[i][w] > 0) {
                System.out.println("Item " + i + ": " + weights[i] + ", " + values[i]);
                totalWeight += weights[i];
                totalValue += values[i];
                selectedItems[i] = 1;
            } else if (i > 0 && dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item " + i + ": " + weights[i] + ", " + values[i]);
                totalWeight += weights[i];
                totalValue += values[i];
                w -= weights[i];
                selectedItems[i] = 1;
            } else {
                selectedItems[i] = 0;
            }
        }
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total value: " + totalValue);
        return selectedItems;
    }
}