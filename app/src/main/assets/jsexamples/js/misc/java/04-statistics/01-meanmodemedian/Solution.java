import java.io.*;
import java.util.*;

public class Solution {

    private static double calculateMedian(Object[] a, int n) {
        if (n%2 == 1) { // ODD
            return (double)a[(int) n/2];
        } else { // EVEN
            int k = n/2;
            double m = (double)a[k-1] + (double)a[k];
            return m/2;
        }
    }

    private static int calculateMode(Object[] a, int n) {
        double maxValue = (double) a[0];
        double lastValue = maxValue;
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < n; i++) {
            if ((double) a[i] == lastValue) {
                count++;
            } else {
                count = 1;
                lastValue = (double) a[i];
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = lastValue;
            }
        }
        return (int) maxValue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Double> list = new ArrayList<>();

        double total = 0.0;
        double mode = 0.0;
        int modeCount = 0;
        for (int i=0; i<n; i++) {
            double x = in.nextDouble();
            total += x;
            list.add(x);
        }

        Object array[] = list.toArray();
        Arrays.sort(array);

        in.close();
        System.out.println(total/n); // MEAN

        System.out.println(calculateMedian(array,n));
        System.out.println(calculateMode(array,n));
    }
}
/*
Sample Input

10
64630 11735 14216 99233 14470 4978 73429 38120 51135 67060

Sample Output

43900.6
44627.5
4978
*/