import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Sample Input

4
add hack
add hackerrank
find hac
find hak

Sample Output

2
0
 */

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        root.addWord(word.toLowerCase());
    }

    public int count(String prefix) {
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));
            if (lastNode == null) return 0;
        }
        return lastNode.count();
    }

    public void find(String prefix) {
        System.out.println(count(prefix));
    }
}

class TrieNode {
    private TrieNode parent;
    private TrieNode[] children;
    private boolean isLeaf;     //Quick way to check if any children exist
    private boolean isWord;     //Does this node represent the last character of a word
    private char character;     //The character this node represents

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }

    public TrieNode(char character) {
        this();
        this.character = character;
    }

    protected void addWord(String word) {
        isLeaf = false;
        int charPos = word.charAt(0) - 'a';

        if (children[charPos] == null) {
            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this;
        }

        if (word.length() > 1) {
            children[charPos].addWord(word.substring(1));
        } else {
            children[charPos].isWord = true;
        }
    }

    protected TrieNode getNode(char c) {
        return children[c - 'a'];
    }

    protected int count() {
    	int count = 0;
        if (isWord) {
        	count++;
        }

        if (!isLeaf) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    count += children[i].count();
                }
            }
        }
        return count;
    }
}

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Trie t = new Trie();
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];

            switch (op) {
                case "add":
                    t.add(contact);
                    break;
                case "find":
                    t.find(contact);
                    break;
            }
        }

        scanner.close();
    }
}