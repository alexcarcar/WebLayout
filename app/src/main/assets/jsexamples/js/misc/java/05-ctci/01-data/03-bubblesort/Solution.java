import java.util.Scanner;

/*
Sample Input 0

3
1 2 3

Sample Output 0

Array is sorted in 0 swaps.
First Element: 1
Last Element: 3

Explanation 0
The array is already sorted, so swaps take place and we print the necessary three lines of output shown above.

Sample Input 1

3
3 2 1

Sample Output 1

Array is sorted in 3 swaps.
First Element: 1
Last Element: 3

 */
class Solution {
    public static void bubblesort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        int swaps = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                    swaps++;
                }
            }
            lastUnsorted--;
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + array[0]);
        System.out.println("Last Element: " + array[array.length - 1]);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        bubblesort(data);
    }
}