import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int n = A.length();
        boolean pal = true;
        for (int i = 0; i<n/2; i++) {
        	if (A.charAt(i) != A.charAt(n-i-1)) {
        		pal = false;
        		break;
    		}
        }
        System.out.println(pal ? "Yes": "No");
    }
}