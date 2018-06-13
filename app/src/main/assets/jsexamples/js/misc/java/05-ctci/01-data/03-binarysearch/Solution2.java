import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
Sample Input

2
4
5
1 4 5 3 2
4
4
2 2 4 3

Sample Output

1 4
1 2*/

public class Solution2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static int closestIndexWithoutGoingOver(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        return closestIndexWithoutGoingOver(array, x, left, right);
    }

    public static int closestIndexWithoutGoingOver(int[] array, int x, int left, int right) {
        int mid = -1;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (array[mid] == x) {
                return mid - 1;
            } else if (x < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (mid > -1 && array[mid] >= x) mid--;
        return mid;
    }

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        int n = cost.length;
        int[] sortedArray = Arrays.copyOf(cost, n);
        Arrays.sort(sortedArray);

        int maxIndex = closestIndexWithoutGoingOver(sortedArray, money);

        // Check case, for duplicate at maxIndex
        int k = maxIndex+1;
        if (k<n && sortedArray[k] == sortedArray[maxIndex]) maxIndex = k;

        int max = sortedArray[maxIndex];
        HashMap<Integer, Integer> m = new HashMap<>();
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] <= max) {
                if(m.get(cost[i])==null) {
                    m.put(cost[i], i+1);
                } else {
                    duplicates.putIfAbsent(cost[i], i+1);
                }
            }
        }
        if (maxIndex < 0) return;
        int search = -1;
        for (; maxIndex >= 1; maxIndex--) {
            int need = money - sortedArray[maxIndex];
            search = Arrays.binarySearch(sortedArray, 0, maxIndex, need);
            if (search >= 0) break;
        }

        int x1, x2;
        x1 = m.get(sortedArray[search]);
        if (sortedArray[search] != sortedArray[maxIndex]) {
            x2 = m.get(sortedArray[maxIndex]);
        } else {
            x2 = duplicates.get(sortedArray[maxIndex]);
        }
        if (x1<x2) {
            System.out.println(x1 + " " + x2);
        } else {
            System.out.println(x2 + " " + x1);
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}