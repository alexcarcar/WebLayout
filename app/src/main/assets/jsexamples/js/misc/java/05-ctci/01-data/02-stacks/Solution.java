import java.util.Scanner;
import java.util.Stack;

/*
3
{[()]}
{[(])}
{{[[(())]]}}

YES
NO
YES
 */
public class Solution {

    static char opening(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        if (c == '}') return '{';
        return ' ';
    }

    public static boolean isParenthesisMatch(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (c == ')' || c == ']' || c == '}') {
                if (stack.empty())
                    return false;
                else if (stack.peek() == opening(c))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            System.out.println(isParenthesisMatch(expression) ? "YES" : "NO");
        }
        scanner.close();
    }
}