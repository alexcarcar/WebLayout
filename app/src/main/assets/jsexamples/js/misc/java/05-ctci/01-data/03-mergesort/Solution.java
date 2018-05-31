/*
// % set OUTPUT_PATH=out.txt

Sample Input

2
5
1 1 1 2 2
5
2 1 3 1 2


Sample Output

0  
4   

 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static long mergeSort(int[] array) {
        return mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static long mergeSort(int[] array, int[] temp, int a, int b) {
        long inversions = 0, k;
        if (a >= b) {
            return 0;
        }
        int x = (a + b) / 2;
        inversions += mergeSort(array, temp, a, x); // merge the first half
        inversions += mergeSort(array, temp, x + 1, b); // merge the second half
        inversions += mergeHalves(array, temp, a, b); // merge the two halves
        return inversions;
    }

    private static long mergeHalves(int[] array, int[] temp, int a, int b) {
        long inversions = 0;
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
                inversions+=(y-i);
                y++;
            }
            i++;
        }
        System.arraycopy(array, x, temp, i, (m1 - x) + 1);
        System.arraycopy(array, y, temp, i, (b - y) + 1);
        System.arraycopy(temp, a, array, a, size);
        return inversions;
    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return mergeSort(arr);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}