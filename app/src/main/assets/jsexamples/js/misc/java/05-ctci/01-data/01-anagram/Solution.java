import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input
cde
abc

Sample Output
4
*/

public class Solution {
    public static int numberNeeded(String first, String second) {
        char a[] = first.toCharArray();
        char b[] = second.toCharArray();
        String anagram = "";
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b.length; j++) {
                if (a[i] != '#' && a[i]==b[j]) {
                    anagram += a[i];
                    a[i] = '#';
                    b[j] = '#';

                }
            }
        }
        return (a.length+b.length)-2*anagram.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}