import java.io.*;
import java.util.*;

public class Solution {
	static boolean isAnagram(String a, String b) {
		int n = a.length();
		if (n != b.length()) return false;
        char[] a1 = a.toLowerCase().toCharArray();
        char[] a2 = b.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i=0; i<n; i++) if (a1[i] != a2[i]) return false;
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}