import java.util.Random;

public class Sorts {

    public static void measureTime() {
        int[] arr = generateRandomArray();

        long start = System.currentTimeMillis();
//        sortBubble(arr);
//        sortSelection(arr);
        sortInsertion(arr);
        System.out.println(System.currentTimeMillis() - start);
    }


    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int[] array = new int[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100_000_000);
        }
        return array;
    }
//time = 15879 ms
    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
//time = 5043 ms
    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
//time = 815 ms
    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}