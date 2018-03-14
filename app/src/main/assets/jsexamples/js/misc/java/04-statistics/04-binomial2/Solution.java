import java.util.Scanner;

/*
Sample Input

12 10

Sample Output
1.234
2.123

A manufacturer of metal pistons finds that, on average, 12% of the pistons they manufacture
are rejected because they are incorrectly sized. What is the probability that a batch of
10 pistons will contain:

    1. No more than 2 rejects?
    2. At least 2 rejects?


*/
public class Solution {

    static long choose(long total, long choose) {
        if (total < choose)
            return 0;
        if (choose == 0 || choose == total)
            return 1;
        return choose(total - 1, choose - 1) + choose(total - 1, choose);
    }

    static double calc(double p, double q, int n, int k) {
        return choose(n, k) * Math.pow(p, k) * Math.pow(q, n - k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double p = in.nextInt()/100.0;
        int n = in.nextInt();
        double q = 1 - p;

        // No more than 2 rejects
        double answer = 0;
        answer += calc(p, q, n, 0);
        answer += calc(p, q, n, 1);
        answer += calc(p, q, n, 2);
        System.out.printf("%.3f\n", answer);

        // At least 2 rejects?
        answer = 0;
        answer += calc(p, q, n, 0);
        answer += calc(p, q, n, 1);
        System.out.printf("%.3f\n", 1 - answer);
    }
}