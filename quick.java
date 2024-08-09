import java.util.Random;

public class quick {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = rand.nextInt(10000);
            }
            long startTime = System.nanoTime();
            quickSort(array, 0, array.length - 1);
            long endTime = System.nanoTime();
            double elapsedTime = (endTime - startTime) / 1_000_000_000.0;
            System.out.print("Sorted array: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("Time taken for array size " + size + ": " + elapsedTime + " seconds");
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
}
