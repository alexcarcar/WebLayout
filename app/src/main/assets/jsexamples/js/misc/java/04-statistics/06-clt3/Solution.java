import java.util.Scanner;

/*
Task
You have a sample of 100 values from a population with mean u=500 and with
standard deviation sd=80. Compute the interval that covers the middle 95% of
the distribution of the sample mean; in other words, compute A and B such
that P(A<x<B) = 0.95. Use the value of z=1.96.

Input Format

There are five lines of input (shown below):

100
500
80
.95
1.96

The first line contains the sample size. The second and third lines contain the
respective mean and standard deviation. The fourth line contains the distribution
percentage we want to cover (as a decimal), and the fifth line contains the value
of z.

Output Format

Print the following two lines of output, rounded to a scale of 2 decimal
places (i.e., 1.23 format):

    On the first line, print the value of A.
    On the second line, print the value of B.

*/

public class Solution {

    static double x(double m, double s, double z) {
        return m + z*s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        double u = in.nextDouble();
        double sd = in.nextDouble();
        double p = in.nextDouble();
        double z = in.nextDouble();

        double uPrime = u;
        double sdPrime = sd/Math.sqrt(n);
        double A = x(uPrime, sdPrime, -1*z);
        double B = x(uPrime, sdPrime, z);

        System.out.printf("%.2f\n", A);
        System.out.printf("%.2f\n", B);
    }
}