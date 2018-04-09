import java.util.Scanner;

/*
The final grades for a Physics exam taken by a large group of students have a mean of u = 70 and a 
standard deviation of sd = 10. If we can approximate the distribution of these grades by a normal 
distribution, what percentage of the students:

    Scored higher than 80 (i.e., have a > 80)?
    Passed the test (i.e., have a >= 60)?
    Failed the test (i.e., have a < 60)?

Find and print the answer to each question on a new line, rounded to a scale of decimal places.

Input Format

There are lines of input (shown below):

70 10
80
60

The first line 2 contains space-separated values denoting the respective mean and standard deviation for the exam. 
The second line contains the number associated with question . The third line contains the pass/fail threshold 
number associated with questions and .

If you do not wish to read this information from stdin, you can hard-code it into your program.

Output Format

There are three lines of output. Your answers must be rounded to a scale of decimal places (i.e., format 1.23):

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
        double m = in.nextDouble();
        double s = in.nextDouble();
        double x1 = in.nextDouble();
        double x2 = in.nextDouble();

        double z1 = z(m, s, x1);
        double z2 = z(m, s, x2);

        System.out.printf("%.2f\n", getAreaUnderNormalCurve(z1, 10)*100);

        double k = getAreaUnderNormalCurve(z2, 100);
        System.out.printf("%.2f\n", getAreaUnderNormalCurve(z2, 10)*100);
        System.out.printf("%.2f\n", getAreaUnderNormalCurve(-10, z2)*100);
    }
}