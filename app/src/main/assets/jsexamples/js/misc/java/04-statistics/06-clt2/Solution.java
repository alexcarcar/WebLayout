import java.util.Scanner;

/*
Task
The number of tickets purchased by each student for the University X vs.
University Y football game follows a distribution that has a mean of u=2.4
and a standard deviation of sd=2.0.

A few hours before the game starts, eager students line up to purchase
last-minute tickets. If there are only 250 tickets left, what is the probability
that all students will be able to purchase tickets?

Input Format

There are lines of input (shown below):

250
100
2.4
2.0

The first line contains the number of last-minute tickets available at the box
office. The second line contains the number of students waiting to buy tickets.
The third line contains the mean number of purchased tickets, and the fourth
line contains the standard deviation.

Output Format
Print the probability that 100 students can successfully purchase the 250
remaining tickets, rounded to a scale of 4 decimal places (i.e., 1.2345 format).

*/

public class Solution {

	static double getNormalProbabilityAtZ(double z) {
        return Math.exp(-Math.pow(z, 2) / 2) / Math.sqrt(2 * Math.PI);
    }

    static double getAreaUnderNormalCurve(double z1, double z2) {
        double area = 0.0;
        final int rectangles = 1000000; // more rectangles = more precise, less rectangles = quicker execution
        final double width = (z2 - z1) / rectangles;
        for(int i = 0; i < rectangles; i++)
            area += width * getNormalProbabilityAtZ(width * i + z1);
        return area;
    }

    static double z(double m, double s, double x) {
        return (x - m)/s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double left = in.nextDouble();
        double n = in.nextDouble();
        double u = in.nextDouble();
        double sd = in.nextDouble();

        double uPrime = n*u;
        double sdPrime = Math.sqrt(n)*sd;
        double z = z(uPrime, sdPrime, left);

        System.out.printf("%.4f\n", getAreaUnderNormalCurve(-10, z));
    }
}