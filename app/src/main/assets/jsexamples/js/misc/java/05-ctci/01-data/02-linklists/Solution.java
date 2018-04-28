class Node {
    int data;
    Node next;
}

public class Solution {
    
// Detect a cycle in a linked list. Note that the head pointer may be 'null'
// if the list is empty.


    static boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        Sample Inputs
        [1] -> null
        [1] -> [2] -> [3] -> (2)
         
        Sample Output
        0
        1 */

        // build linked list #1: [1] -> null
        Node list1 = new Node();
        list1.data = 1;
        list1.next = null;

        // build linked list #1: [1] -> [2] -> [3] -> (2)
        Node list2 = new Node();
        Node n2, n3;
        n2 = new Node();
        n3 = new Node();
        list2.data = 1;
        list2.next = n2;
        n2.data = 2;
        n2.next = n3;
        n3.data = 3;
        n3.next = n2;

        System.out.println(hasCycle(list1)?1:0);
        System.out.println(hasCycle(list2)?1:0);
    }

}
