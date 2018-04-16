import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Andrea has a simple equation:

Y = a + b1*f1 + b2*f2 + ... + bm*fm

for (m+1) real constants (a, f1, f2, ... , fm). We can say that the value of Y depends on
m features. Andrea studies this equation for different feature sets (f1, f2, ..., fm) and records
each respective value of Y.

If she has q new feature sets, can you help Andrea find the value of Y for each of the sets?

Sample Input

2 7
0.18 0.89 109.85
1.0 0.26 155.72
0.92 0.11 137.66
0.07 0.37 76.17
0.85 0.16 139.75
0.99 0.41 162.6
0.87 0.47 151.77
4
0.49 0.18
0.57 0.83
0.56 0.64
0.76 0.18

Sample Output

105.22
142.68
132.94
129.71


Input Format

The first line contains 2 space-separated integers, m (the number of observed features) and
n (the number of feature sets Andrea studied), respectively.

Each of the subsequent lines contain space-separated decimals; the first elements are
features (f1, f2, f3, ... fm), and the last element is the value of Y for the line's feature set.

The next line contains a single integer, q, denoting the number of feature sets Andrea wants
to query for.  Each of the q subsequent lines contains m space-separated decimals describing
the feature sets.


*/
public class Solution {

    public static double[][] transposeMatrix(double [][] m){
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); // # of observed features
        int n = in.nextInt(); // # of of feature sets

        double[][] X = new double[n][m+1];
        double[][] Xt = transposeMatrix(X);
        double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            X[i][0] = 1;
            for (int j = 0; j < m; j++) {
                X[i][j+1] = in.nextDouble();
            }
            Y[i] = in.nextDouble();
        }
        System.out.println(Arrays.deepToString(X).replace(']', '\n'));
        System.out.println(Arrays.deepToString(Xt));
        System.out.println(Y);

        int q = in.nextInt(); // # of queries
        double[][] b = new double[q][m];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = in.nextDouble();
            }
        }

        System.out.println(X.length);
        System.out.println(Y.length);
        System.out.println(b.length);

        //System.out.printf("%.2f", solve(X, Y, 80));
    }
}