import java.io.*;
import java.util.*;

/*
Sample Input

5
10 40 30 50 20

Sample Output
14.1

*/
public class Solution {

	static double standardDeviation(ArrayList<Integer> list, int n, double mean) {
		double total = 0;
		for (int i=0; i<n; i++) {
			double x = list.get(i) - mean;
			total += x*x;
		}
		return Math.sqrt(total/n);
	}

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	ArrayList<Integer> list = new ArrayList<>();
    	double total = 0;
    	for (int i=0; i<n; i++) {
    		int x = in.nextInt();
    		list.add(x);
    		total += x;
    	}
    	System.out.printf("%.1f", standardDeviation(list, n, total/n));
    }
}