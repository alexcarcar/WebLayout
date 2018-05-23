package alex.carcar.lib;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] array) {
        MergeSort.mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int a, int b) {
        if (a >= b) {
            return;
        }
        int x = (a + b) / 2;
        MergeSort.mergeSort(array, temp, a, x); // merge the first half
        MergeSort.mergeSort(array, temp, x + 1, b); // merge the second half
        MergeSort.mergeHalves(array, temp, a, b); // merge the two halves
    }

    private static void mergeHalves(int[] array, int[] temp, int a, int b) {
        int m1 = (a + b) / 2;
        int m2 = m1 + 1;
        int size = (b - a) + 1;

        int x = a;
        int y = m2;
        int i = a;

        while ((x <= m1) && (y <= b)) {
            if (array[x] <= array[y]) {
                temp[i] = array[x];
                x++;
            } else {
                temp[i] = array[y];
                y++;
            }
            i++;
        }
        System.arraycopy(array, x, temp, i, (m1 - x) + 1);
        System.arraycopy(array, y, temp, i, (b - y) + 1);
        System.arraycopy(temp, a, array, a, size);
    }

    public static void main(String[] args) {
        // int[] data = {9, 2, 12, 4, 5, 9, 3, 2, 1, 15, 3, 6};
        // int[] data = {3, 2, 1};
        // int[] data = {4, 2, 1, 5};
        int[] data = {10, 5, 2, 7, 4, 12, 1, 8, 6, 11, 3};
        System.out.println("Before sorting: " + Arrays.toString(data));
        MergeSort.mergeSort(data);
        System.out.println("After sorting: " + Arrays.toString(data));
    }
}
