public class merge {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 0, 0, 1};
        long startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000_000.0;
        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Time taken: " + elapsedTime + " seconds");
    }

    public static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merging(array, low, mid, high);
    }

    public static void merging(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp[k++] = array[left++];
            }
            else{
                temp[k++]=array[right++];
            }
        }
        while(left<=mid){
            temp[k++]=array[left++];
        }
        while (right <= high) {
            temp[k++] = array[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }
    }
}