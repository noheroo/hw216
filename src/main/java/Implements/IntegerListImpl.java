package Implements;

import Exceptions.ArrayIsFullException;
import Exceptions.BadIndexException;
import Exceptions.ItemIsNullException;
import Interfaces.IntegerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] storage;
    private int size;

//    public IntegerListImpl() {
//        storage = new Integer[5];
//    }

    public IntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }


    @Override
    public Integer add(Integer item) {
        if (size == storage.length) {
            storage = grow(storage);
        }
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);

        int index = indexOf(item);

        return remove(index);

    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = storage[index];

        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private static Integer[] grow(Integer[] integers) {
        return Arrays.copyOf(integers, (int) (integers.length * 1.5));
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ItemIsNullException();
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new ArrayIsFullException();
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new BadIndexException();
        }
    }

    private static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
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

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private boolean binarySearch(Integer item) {
        Integer[] storageWithoutNull = new Integer[size];
        System.arraycopy(storage, 0, storageWithoutNull, 0, size);
        quickSort(storageWithoutNull, 0, storageWithoutNull.length - 1);
        int min = 0;
        int max = storageWithoutNull.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item.equals(storageWithoutNull[mid])) {
                return true;
            }
            if (item < storageWithoutNull[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
