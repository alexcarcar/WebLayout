/*
	Given the words in the magazine and the words in the ransom note,
	print Yes if he can replicate his ransom note exactly using whole
	words from the magazine; otherwise, print No.

Sample Input 0

6 4
give me one grand today night
give one grand today

Sample Output 0

Yes

Sample Input 1

6 5
two times three is not four
two times two is four

Sample Output 1

No


*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i < m; i++){
            String word = in.next();
            Integer count = map.get(word);
            count = (count == null ? 0: count)+1;
            map.put(word, count);
        }
        boolean  possible = true;
        for(int i=0; i < n; i++){
            String word = in.next();
            Integer count = map.get(word);
            if (count == null || count == 0) {
            	possible = false;
            	break;
            }
            map.put(word, --count);
        }
        System.out.println(possible?"Yes":"No");
    }
}