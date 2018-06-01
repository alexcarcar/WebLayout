/***
 *
 * Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together dollars
 * for ice cream.
 *
 * On any given day, the parlor offers a line of flavors.
 *
 * Each flavor, i, is numbered sequentially with a unique ID number from 1 to n
 * and has a cost, cost(i), associated with it.
 *
 * Given the value of money and the cost of each flavor for trips to the Ice Cream
 * Parlor, help Sunny and Johnny choose two distinct flavors such that they spend their
 * entire pool of money during each visit.
 *
 * For each trip to the parlor, print the ID numbers for the two types of ice cream that
 * Sunny and Johnny purchase as two space-separated integers on a new line.
 * You must print the smaller ID first and the larger ID second.
 *
 * Note: Two ice creams having unique IDs and may have the same cost (i.e., cost(i) = cost(j)).
 *
 * Input Format
 *
 * The first line contains an integer, t, denoting the number of trips to the ice cream parlor.
 * The 3t subsequent lines describe all of Sunny and Johnny's trips to the parlor; each trip is
 * described as follows:
 *
 * The first line contains money.
 * The second line contains n.
 * The third line contains space-separated integers denoting the cost of each respective flavor.
 * The integer corresponds to the cost, cost(i), for the ice cream with ID number (where 1<=i<=n).
 *
 */

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

import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    // Complete the solve function below.
    static void solve(int[] arr, int money) {
    	Arrays.sort(arr);
        System.out.print(Arrays.toString(arr));
        System.out.println(" " + money);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            solve(arr, money);
        }

        scanner.close();
    }
}