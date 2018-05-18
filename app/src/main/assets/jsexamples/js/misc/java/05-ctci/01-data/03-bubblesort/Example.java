import java.util.Arrays;

class Example {

    public static void bubblesort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        int pass = 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
            if (!isSorted) {
                System.out.println("Pass #" + pass + ": " + Arrays.toString(array));
                pass++;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {9, 2, 12, 4, 5, 9, 3, 2, 1, 15, 3, 6};
        System.out.println("Before sorting: " + Arrays.toString(data));
        bubblesort(data);
        System.out.println("After sorting: " + Arrays.toString(data));
    }

}