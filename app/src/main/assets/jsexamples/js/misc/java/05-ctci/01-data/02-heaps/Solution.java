import java.util.PriorityQueue;
import java.util.Scanner;
/*
Sample Input

6
12
4
5
3
8
7

Sample Output

12.0
8.0
5.0
4.5
5.0
6.0

 */

class Median {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

    public float median() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if (minSize == 0 && maxSize == 0) {
            return 0;
        }
        if (minSize > maxSize) {
            return minHeap.peek();
        }
        if (minSize < maxSize) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2F;
    }

    public void insert(int element) {
        float median = median();
        if (element > median) {
            minHeap.offer(element);
        } else {
            maxHeap.offer(element);
        }
        balanceHeap();
    }

    public void balanceHeap() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        int tmp = 0;
        if (minSize > maxSize + 1) {
            tmp = minHeap.poll();
            maxHeap.offer(tmp);
        }
        if (maxSize > minSize + 1) {
            tmp = maxHeap.poll();
            minHeap.offer(tmp);
        }
    }
}

class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Median m = new Median();
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            m.insert(scanner.nextInt());
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.printf("%.1f\n", m.median());
        }

        scanner.close();
    }
}