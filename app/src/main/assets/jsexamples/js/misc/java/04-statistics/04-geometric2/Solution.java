import java.util.Scanner;

/*
Sample Input
1 3
5

Sample Output
1.234

The probability that a machine produces a defective product is 1/3.
What is the probability that the 1st defect is found during the first 5 inspections??

*/
public class Solution {

    static double calc(double p, double q, int n) {
        return Math.pow(q, n - 1) * p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double p = in.nextDouble() / in.nextDouble();
        double q = 1 - p;
        int n = in.nextInt();
        double answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += calc(p, q, i);
        }
        System.out.printf("%.3f\n", answer);
    }
}