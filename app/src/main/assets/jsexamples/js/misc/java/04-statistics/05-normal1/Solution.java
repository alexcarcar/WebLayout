import java.util.Scanner;

/*
Input Format

There are lines of input (shown below):

20 2
19.5
20 22

In a certain plant, the time taken to assemble a car is a random variable, X, having a normal
distribution with a mean of 20 hours and a 2 standard deviation of hours. What is the probability
that a car can be assembled at this plant in:

    Less than 19.5 hours?
    Between 20 and 22 hours?

*/
public class Solution {

    static double z(double m, double s, double x) {
        return (x - m)/s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double m = in.nextDouble();
        double s = in.nextDouble();
        double x = in.nextDouble();
        double x1 = in.nextDouble();
        double x2 = in.nextDouble();

        // Problem 1 less than x
        double z = z(m, s, x);
        Math.
        System.out.printf("%.3f\n", problem1(l,k));
        System.out.printf("%.3f\n", problem2(l,k));
    }
}