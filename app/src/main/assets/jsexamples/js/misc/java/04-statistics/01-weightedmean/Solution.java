import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> weights = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            list.add(in.nextLong());
        }

        long weight = 0;
        for (int i = 0; i < n; i++) {
            long w = in.nextLong();
            weight += w;
            weights.add(w);
        }
        in.close();

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (list.get(i) * weights.get(i));
        }
        double average = (double) total / (double) weight;
        System.out.printf("%.1f\n",average);
    }
}
/*
Sample Input

5
10 40 30 50 20
1 2 3 4 5

Sample Output

32.0

*/