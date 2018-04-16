import java.util.ArrayList;
import java.util.Scanner;

/*
If a student scored an 80 on the Math aptitude test, what grade would we expect them to achieve
in Statistics? Determine the equation of the best-fit line using the least squares method, then
compute and print the value of y when x=80.


Input Format

There are five lines of input; each line contains two space-separated integers describing a
student's respective and grades:

95 85
85 95
80 70
70 65
60 70

Output Format

Print a single line denoting the answer, rounded to a scale of decimal places (i.e., 1.234 format).

*/
public class Solution {

    static double solve(ArrayList<Double> X, ArrayList<Double> Y, double x0) {
        int n = X.size();
        double Sx = 0, Sy = 0, Sxx = 0, Sxy = 0;
        for (int i = 0; i < n; i++) {
            double x = X.get(i);
            double y = Y.get(i);
            Sx += x;
            Sy += y;
            Sxx += x * x;
            Sxy += x * y;
        }
        double ux = Sx / n;
        double uy = Sy / n;
        double b = (n * Sxy - Sx * Sy) / (n * Sxx - Sx * Sx);
        double a = uy - b * ux;
        return a + b * x0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        ArrayList<Double> X = new ArrayList<>();
        ArrayList<Double> Y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            X.add(in.nextDouble());
            Y.add(in.nextDouble());
        }
        System.out.printf("%.3f", solve(X, Y, 80));
    }
}