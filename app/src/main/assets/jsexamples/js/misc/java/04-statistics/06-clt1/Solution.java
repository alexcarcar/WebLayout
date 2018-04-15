import java.util.Scanner;

/*
Task
A large elevator can transport a maximum of 9800 pounds. Suppose a load of
cargo containing 49 boxes must be transported via the elevator. The box weight
of this type of cargo follows a distribution with a mean of u=205 pounds and a
standard deviation of s=15 pounds. Based on this information, what is the
probability that all boxes can be safely loaded into the freight elevator and
transported?

Input Format
There are lines of input (shown below):

9800
49
205
15

Output Format

Print the probability that the elevator can successfully transport all 49 boxes,
rounded to a scale of 4 decimal places (i.e., 1.2345 format).
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
        double max = in.nextDouble();
        double n = in.nextDouble();
        double u = in.nextDouble();
        double sd = in.nextDouble();

        double uPrime = n*u;
        double sdPrime = Math.sqrt(n)*sd;
        double z = z(uPrime, sdPrime, max);

        System.out.printf("%.4f\n", getAreaUnderNormalCurve(-10, z));
    }
}