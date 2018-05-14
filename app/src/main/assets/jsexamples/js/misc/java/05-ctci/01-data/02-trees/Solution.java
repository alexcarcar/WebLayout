class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

}

class Solution {

    static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBST(Node node, int min, int max) {
        return (node == null) || (min < node.data && node.data < max && checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max));
    }

    public static void main(String[] args) {
        Node n = new Node(6);
        n.insert(7);
        n.insert(5);
        n.insert(22);
        n.insert(12);
        n.insert(28);
        System.out.println(n.contains(77)); // false
        System.out.println(n.contains(22)); // true
        n.printInOrder(); // 5 6 7 12 22 28
        System.out.println(checkBST(n)); // true
    }
}