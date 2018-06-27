import java.io.IOException;
import java.util.Scanner;

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

Sample Input
5
4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output
8

Sample Input
5
5
0 1 1 1 1
1 0 0 0 1
1 1 0 1 0
0 1 0 1 1
0 1 1 1 0

Sample Output
15

 */

public class Solution {

    static int countRegion(int i, int j, int[][] grid, boolean[][] visited, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) return 0;
        if (visited[i][j]) return 0;

        visited[i][j] = true;
        if (grid[i][j] == 0) return 0;
        // System.out.println(i + "," + j);
        int count = 1;

        // row above
        count += countRegion(i - 1, j + 1, grid, visited, n, m);
        count += countRegion(i, j + 1, grid, visited, n, m);
        count += countRegion(i + 1, j + 1, grid, visited, n, m);

        // same row
        count += countRegion(i - 1, j, grid, visited, n, m);
        count += countRegion(i + 1, j, grid, visited, n, m);

        // row below
        count += countRegion(i - 1, j - 1, grid, visited, n, m);
        count += countRegion(i, j - 1, grid, visited, n, m);
        count += countRegion(i + 1, j - 1, grid, visited, n, m);

        return count;
    }

    static int maxRegion(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    visited[i][j] = true;
                    continue;
                }
                int c = countRegion(i, j, grid, visited, n, m);
                // if (c > 0) System.out.println("c=" + c);
                if (c > max) max = c;
            }
        }
        return max;
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
