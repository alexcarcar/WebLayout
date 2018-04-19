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

    private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    private static double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    private static double[][] multiply(double[][] a, double[][] b) {
        if (a[0].length != b.length)
            throw new IllegalStateException("invalid dimensions");

        double[][] matrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < a[i].length; k++)
                    sum += a[i][k] * b[k][j];
                matrix[i][j] = sum;
            }
        }

        return matrix;
    }

    private static double[][] rref(double[][] matrix) {
        double[][] rref = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            rref[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        int r = 0;
        for (int c = 0; c < rref[0].length && r < rref.length; c++) {
            int j = r;
            for (int i = r + 1; i < rref.length; i++)
                if (Math.abs(rref[i][c]) > Math.abs(rref[j][c]))
                    j = i;
            if (Math.abs(rref[j][c]) < 0.00001)
                continue;

            double[] temp = rref[j];
            rref[j] = rref[r];
            rref[r] = temp;

            double s = 1.0 / rref[r][c];
            for (j = 0; j < rref[0].length; j++)
                rref[r][j] *= s;
            for (int i = 0; i < rref.length; i++) {
                if (i != r) {
                    double t = rref[i][c];
                    for (j = 0; j < rref[0].length; j++)
                        rref[i][j] -= t * rref[r][j];
                }
            }
            r++;
        }

        return rref;
    }

    private static double[][] transpose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    // ----

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); // # of observed features
        int n = in.nextInt(); // # of of feature sets

        double[][] X = new double[n][m + 1];
        double[][] Y = new double[n][1];
        for (int i = 0; i < n; i++) {
            X[i][0] = 1;
            for (int j = 0; j < m; j++) {
                X[i][j + 1] = in.nextDouble();
            }
            Y[i][0] = in.nextDouble();
        }
        double[][] Xt = transpose(X);
        double[][] XtX = multiply(Xt, X);
        double[][] inv_XtX = inverse(XtX);
        double[][] inv_XtX_Xt = multiply(inv_XtX, Xt);
        double[][] B = multiply(inv_XtX_Xt, Y);

        int q = in.nextInt(); // # of queries
        double[][] Q = new double[q][m+1];
        for (int i = 0; i < q; i++) {
            Q[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                Q[i][j] = in.nextDouble();
            }
        }
        double[][] results = multiply(Q, B);
        for (int i=0; i<results.length; i++) {
        	System.out.printf("%.2f\n", results[i][0]);
        }
    }
}