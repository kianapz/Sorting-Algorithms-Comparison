import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Bubble Sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort algorithm
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort algorithm
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Insertion Sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Heap Sort algorithm
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap in max order
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Counting Sort algorithm
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int value : arr) {
            count[value - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // Radix Sort algorithm
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];

        for (int value : arr) {
            count[(value / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy3 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy4 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy5 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy6 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy7 = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();
        bubbleSort(arrCopy1);
        long bubbleSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        mergeSort(arrCopy2);
        long mergeSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        quickSort(arrCopy3, 0, arrCopy3.length - 1);
        long quickSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        insertionSort(arrCopy4);
        long insertionSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        selectionSort(arrCopy5);
        long selectionSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        heapSort(arrCopy6);
        long heapSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        countingSort(arrCopy7);
        long countingSortTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        radixSort(arrCopy7);
        long radixSortTime = System.nanoTime() - startTime;

        // Print the times
        System.out.println("Bubble Sort Time: " + bubbleSortTime / 1000000 + " ms");
        System.out.println("Merge Sort Time: " + mergeSortTime / 1000000 + " ms");
        System.out.println("Quick Sort Time: " + quickSortTime / 1000000 + " ms");
        System.out.println("Insertion Sort Time: " + insertionSortTime / 1000000 + " ms");
        System.out.println("Selection Sort Time: " + selectionSortTime / 1000000 + " ms");
        System.out.println("Heap Sort Time: " + heapSortTime / 1000000 + " ms");
        System.out.println("Counting Sort Time: " + countingSortTime / 1000000 + " ms");
        System.out.println("Radix Sort Time: " + radixSortTime / 1000000 + " ms");
    }
}
