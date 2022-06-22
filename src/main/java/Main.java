import Implements.IntegerListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntegerListImpl integerList = new IntegerListImpl(5);

        integerList.add(5);
        integerList.add(5);
        integerList.add(5);
        integerList.add(5);
        integerList.add(4);
        integerList.add(5);

        System.out.println("integerList.contains(5) = " + integerList.contains(4));

//       Sorts.measureTime();
//        int[] array = Sorts.generateRandomArray(5, 5);
//        System.out.println(Arrays.toString(array));
//        quickSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
//        System.out.println("binarySearch(array, 3) = " + binarySearch(array, 3));
    }        
        private static int[] grow(int[] ints) {
            return Arrays.copyOf(ints, (int) (ints.length*1.5))   ;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static boolean binarySearch(int[] array, Integer item) {
        quickSort(array, 0, array.length - 1);
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item.equals(array[mid])) {
                return true;
            }
            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
