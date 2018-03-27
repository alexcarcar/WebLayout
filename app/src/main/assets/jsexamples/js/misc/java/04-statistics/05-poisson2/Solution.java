import java.util.Scanner;

/*
Input Format
A single line comprised of space-separated values denoting the respective means for A and B:
0.88 1.55

The manager of a industrial plant is planning to buy a machine of either type A or type B.
For each day’s operation:

    The number of repairs, X, that machine needs is a Poisson random variable with mean 0.88.
    The daily cost of operating is CA = 160 + 40X^2.

    The number of repairs, Y, that machine needs is a Poisson random variable with mean 1.55.
    The daily cost of operating is CB = 128 + 40Y^2.

Assume that the repairs take a negligible amount of time and the machines are maintained nightly to ensure that they operate like new at the start of each day. Find and print the expected daily cost for each machine.

*/
public class Solution {

    static double EX2(double l) {
        return l + Math.pow(l, 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("%.3f\n", 160 + 40*EX2(in.nextDouble()));
        System.out.printf("%.3f\n", 128 + 40*EX2(in.nextDouble()));
    }
}