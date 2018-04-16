import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Sample Input

10
10 9.8 8 7.8 7.7 1.7 6 5 1.4 2
200 44 32 24 22 17 15 12 8 4

Sample Output

0.903

*/
public class Solution {

    static ArrayList<Integer> buildRankArray(ArrayList<Double> X) {
        int n = X.size();
        ArrayList<Double> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++) sortedList.add(X.get(i));
        Collections.sort(sortedList);
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < n; i++) map.put(sortedList.get(i), new Integer(i + 1));
        ArrayList<Integer> rankList = new ArrayList<>();
        for (int i = 0; i < n; i++) rankList.add(map.get(X.get(i)));
        return rankList;
    }

    static double spearman(ArrayList<Double> X, ArrayList<Double> Y) {
        ArrayList<Integer> rankX = buildRankArray(X);
        ArrayList<Integer> rankY = buildRankArray(Y);
        int n = X.size();
        double bottom = n * (n * n - 1);
        double top = 0;
        for (int i = 0; i < n; i++) {
            double d = rankX.get(i) - rankY.get(i);
            top += d * d;
        }
        return 1 - (6 * top / bottom);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Double> X = new ArrayList<>();
        ArrayList<Double> Y = new ArrayList<>();
        for (int i = 0; i < n; i++) X.add(in.nextDouble());
        for (int i = 0; i < n; i++) Y.add(in.nextDouble());
        System.out.printf("%.3f", spearman(X, Y));
    }
}