import java.io.*;
import java.util.*;

/*
Sample Input

6
6 12 8 10 20 16
5 4 3 2 1 5

Sample Output

9.0

*/
public class Solution {

	static double getMedian(ArrayList<Integer> list, int i, int j) {
		int n = j - i + 1;
		int k = (i+j)/2;
		boolean odd = n%2 == 1;
		if (odd) {
			return list.get(k);
		} else {
			return (list.get(k)+list.get(k+1))/2;
		}
	}

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	ArrayList<Integer> x = new ArrayList<>();
    	ArrayList<Integer> list = new ArrayList<>();

    	for (int i=0; i<n; i++) {
    		x.add(in.nextInt());
    	}
    	int nData = 0;
    	for (int i=0; i<n; i++) {
    		int freq = in.nextInt();
    		int value = x.get(i);
    		for (int j=0; j<freq; j++) {
    			list.add(value);
			}
    		nData += freq;
    	}
    	Collections.sort(list);
    	n = list.size();
    	double a, b;
    	if (n%2==1) {
	    	a = getMedian(list,0,n/2-1);
	    	b = getMedian(list,n/2+1,n-1);
    	} else {
	    	a = getMedian(list,0,n/2-1);
	    	b = getMedian(list,n/2,n-1);
    	}
    	System.out.printf("%.1f", b-a);
    }
}