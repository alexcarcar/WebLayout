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

	static int getMedian(ArrayList<Integer> list, int i, int j) {
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
    	ArrayList<Integer> list = new ArrayList<>();
    	ArrayList<Integer> x = new ArrayList<>();
    	for (int i=0; i<n; i++) {
    		x.add(in.nextInt());
    	}
    	for (int i=0; i<n; i++) {
    		f.add(in.nextInt());
    	}
    	Collections.sort(list);
    	n = list.size();
    	if (n%2==1) {
	    	System.out.println(getMedian(list,0,n/2-1));
	    	System.out.println(getMedian(list,0,n-1));
	    	System.out.println(getMedian(list,n/2+1,n-1));    		
    	} else {
	    	System.out.println(getMedian(list,0,n/2-1));
	    	System.out.println(getMedian(list,0,n-1));
	    	System.out.println(getMedian(list,n/2,n-1));    		
    	}
    }
}