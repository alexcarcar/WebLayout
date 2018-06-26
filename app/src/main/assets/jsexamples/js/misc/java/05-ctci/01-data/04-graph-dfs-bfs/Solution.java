import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Sample Input

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

Sample Output

5
 */

public class Solution {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
    	int n = grid.length;
    	int m = grid[0].length;

    	boolean[][] visited = new boolean[n][m];
    	
    	System.out.println(n + "x" + m);
    	int max = 0;

    	for (int i=0; i<n; i++) {
    		for (int j=0; j<m; j++) {
    			if (grid[i][j] == 0 || visited[i][j]) {
	    			visited[i][j] = true;
    				continue;
    			}
    			visited[i][j] = true;
    			System.out.println(i + "," + j);
    			// c = count(i,j);
    			// if (c>max) max = c;
    		}
    	}
    	return 5;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);
        System.out.println(res);
        scanner.close();
    }
}
