import java.io.*;
import java.util.*;

/*
Sample Input

10
10 9.8 8 7.8 7.7 7 6 5 4 2 
200 44 32 24 22 17 15 12 8 4

Sample Output

0.612


*/
public class Solution {

	static double standardDeviation(ArrayList<Double> list, int n, double mean) {
		double total = 0;
		for (int i=0; i<n; i++) {
			double x = list.get(i) - mean;
			total += x*x;
		}
		return Math.sqrt(total/n);
	}

    static double pearson(double ux, double sx, double uy, double sy, ArrayList<Double> X, ArrayList<Double> Y) {
        int n = X.size();
        double bottom = n*sx*sy;
        double top = 0;
        for (int i=0; i<n; i++) {
            top += (X.get(i)-ux)*(Y.get(i)-uy);
        }
        return top/bottom;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	ArrayList<Double> list1 = new ArrayList<>();
    	double total = 0;
    	for (int i=0; i<n; i++) {
    		double x = in.nextDouble();
    		list1.add(x);
    		total += x;
    	}
        double ux = total/n;
    	double sx = standardDeviation(list1, n, ux);

        ArrayList<Double> list2 = new ArrayList<>();
        total = 0;
        for (int i=0; i<n; i++) {
            double x = in.nextDouble();
            list2.add(x);
            total += x;
        }

        double uy = total/n;
        double sy = standardDeviation(list2, n, uy);

        System.out.printf("%.3f", pearson(ux, sx, uy, sy, list1, list2));
    }
}