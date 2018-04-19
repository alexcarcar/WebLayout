import java.util.Scanner;
/*
A left rotation operation on an array of size n shifts each of
the array's elements 1 unit to the left. For example, if 2
left rotations are performed on array [1, 2, 3, 4, 5], then
the array would become [3, 4, 5, 1, 2].

Given an array of n integers and a number, d, perform d left
rotations on the array. Then print the updated array as a
single line of space-separated integers.

Sample Input
5 4
1 2 3 4 5

Sample Output
5 1 2 3 4
*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int i=0; i < n; i++) a[i] = in.nextInt();
        for(int i=0; i<n; i++) System.out.print(a[(i+k)%n] + " ");
        System.out.println();
    }
}