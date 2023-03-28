import java.util.Arrays;
import java.util.Random;

public class ImplementSort {
    private final static int SIZE = 100000000;
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(SIZE);
        }
        System.out.println("Before sort: " + isSort(arr));
        long start = System.currentTimeMillis();
        countingSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("After sort: " + isSort(arr));
        System.out.println("Counting sort: " + (end - start) + "ms");

        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(SIZE);
        }
        System.out.println("Before sort: " + isSort(arr));
        start = System.currentTimeMillis();
        heapSort(arr);
        end = System.currentTimeMillis();
        System.out.println("After sort: " + isSort(arr));
        System.out.println("Heap sort: " + (end - start) + "ms");
    }

    private static boolean isSort(int[] arr) {
       for (int i = 1; i < arr.length; i++) {
           if (arr[i - 1] > arr[i]) {
               return false;
           }
       }
       return true;
    }



    public static void countingSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i < min) {
                min = i;
            } else  if (i > max) {
                max = i;
            }
        }

        int[] counts = new int[max - min + 1];

        for (int j : arr) {
            counts[j - min]++;
        }

        int sortedIdx = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[sortedIdx++] = i + min;
                counts[i]--;
            }
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        buildHeap(arr, n);
        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int left = i*2 + 1;
        int right = i*2 + 2;
        int greater;

        if (left < n && arr[left] > arr[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && arr[right] > arr[greater]) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, greater, i);
            heapify(arr, n, greater);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
