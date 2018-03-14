import java.util.Scanner;

/*
Sample Input

1.09 1

Sample Output
1.234

The ratio of boys to girls for babies born in Russia is 1.09 to 1.
If there is 1 child born per birth, what proportion of Russian families with exactly
6 children will have at least 3 boys?

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
        double boys = in.nextDouble();
        double girls = in.nextDouble();
        double p = boys / (boys + girls);
        double q = 1 - p;

        double answer = 0;
        for (int k = 3; k <= 6; k++) {
            answer += calc(p, q, 6, k);
        }
        System.out.printf("%.3f", answer);
    }
}