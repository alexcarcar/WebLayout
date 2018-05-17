import java.util.HashMap;
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
    private HashMap<Character, TrieNode> children;
    private Integer size;
    private boolean isLeaf;     //Quick way to check if any children exist
    private boolean isWord;     //Does this node represent the last character of a word
    private char character;     //The character this node represents

    public TrieNode() {
        children = new HashMap<>();
        isLeaf = true;
        isWord = false;
        size = null;
    }

    public TrieNode(char character) {
        this();
        this.character = character;
    }

    protected void addWord(String word) {
        isLeaf = false;
        char ch = word.charAt(0);

        if (!children.containsKey(ch)) {
            children.put(ch, new TrieNode(ch));
            children.get(ch).parent = this;
        } else {
            children.get(ch).size = null;
        }

        if (word.length() > 1) {
            children.get(ch).addWord(word.substring(1));
        } else {
            children.get(ch).isWord = true;
        }
    }

    protected TrieNode getNode(char c) {
        return children.get(c);
    }

    protected int count() {
        int count = 0;
        if (isWord) {
            count++;
        }

        if (!isLeaf) {
            for (TrieNode child : children.values()) {
                if (child.size == null) {
                    child.size = child.count();
                }
                count += child.size;
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