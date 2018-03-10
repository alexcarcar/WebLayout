import java.io.*;
import java.util.*;

/*
Sample Input
------------
9
3 7 8 5 12 14 21 13 18

Sample Output
------------- (odd)
3 5 7 8 12 13 14 18 21
         |
         n/2 = 9/2 = 4
    n/2-1  n/2+1  
6 = (5+7)/2
12 = Middle
16 = (14+18)/2
*/

/*
Sample Input
------------
8
1 4 6 8 10 11 23 25
         |
        n/2
      n/2-1  
Sample Output
-------------
5 = (4+6)/2
9 = (8+10)/2
17 = (11+23)/2
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
    	for (int i=0; i<n; i++) {
    		list.add(in.nextInt());
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