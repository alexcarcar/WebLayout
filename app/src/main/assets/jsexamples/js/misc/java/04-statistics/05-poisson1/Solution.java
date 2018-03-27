import java.util.Scanner;

/*
Sample Input
2.5
5

Sample Output
0.234

A random variable, X, follows Poisson distribution with mean of 2.5.
Find the probability with which the random variable is equal to 5.

*/
public class Solution {

    static double factorial(double k) {
        if (k <=1) {
            return 1;
        }
        return k * factorial(k-1);
    }

    static double P(double l, double k) {
        return Math.pow(l, k) * Math.exp(-l) / factorial(k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double l = in.nextDouble();
        double k = in.nextDouble();
        System.out.printf("%.3f\n", P(l,k));
    }
}