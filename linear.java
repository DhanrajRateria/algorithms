import java.util.*;
public class linear {
    public static void main(String[] args) {
        long startTime, endTime;
        Scanner sc = new Scanner(System.in);
        int n, key;
        System.out.println("Enter the length of the array");
        n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched");
        key = sc.nextInt();
        sc.close();
        int loc = -1;
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (array[i] == key) {
                System.out.println("Key found at " + i);
                loc = i;
            }
        }
        if (loc == -1) {
            System.out.println("Key not found");
        }
        endTime = System.nanoTime();
        double timeLinear = (endTime - startTime) / 1e9;
        System.out.println("Time taken: "+ timeLinear);
    }
}