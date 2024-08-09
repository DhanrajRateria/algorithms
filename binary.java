import java.util.*;
public class binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        long startTime, endTime;
        System.out.println("Enter the length of the array");
        n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println("Enter the element to be searched");
        key = sc.nextInt();
        sc.close();
        startTime = System.nanoTime();
        int ind = recBinary(array, key, 0, n - 1);
        System.out.println("Element found at " + ind);
        endTime = System.nanoTime();
        double timeBinary = (endTime - startTime) / 1e9;
        System.out.println("Time taken: "+ timeBinary);
    }
    public static int recBinary(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] <= target) {
                return recBinary(array, target, mid + 1, high);
            } else {
                return recBinary(array, target, low, mid - 1);
            }
        }
        return -1;
    }
}