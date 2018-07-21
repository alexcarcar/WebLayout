import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

Input:
1
6 4
1 2
2 3
3 4
1 5
1

Output: 6 12 18 6 -1


Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2

Sample Output

6 6 -1
-1 6

 */
public class Solution {
    public static class Graph {
        private int size = 0;
        private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

        public Graph(int s) {
            size = s;
        }

        public static class Node {
            private int id;
            LinkedList<Node> adjacent = new LinkedList<Node>();
            private Node(int id) {
                this.id = id;
            }
        }

        private Node getNode(int id) {
            Node n = nodeLookup.get(id);
            if (n != null) return n;
            n = new Node(id);
            nodeLookup.put(id, n);
            return n;
        }

        public void addEdge(int source, int destination) {
            Node s = getNode(source);
            Node d = getNode(destination);
            s.adjacent.add(d);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            for (int i=0; i<this.size; i++) {
                if (i != startId) {
                    System.out.print("Distance from "+(startId+1)+" to "+(i+1)+": ");
                    System.out.println(hasPathBFS(startId, i));
                }
            }
        	int[] results = {6, 2};
        	return results;
        }

        public boolean hasPathBFS(int source, int destination) {
            return hasPathBFS(getNode(source), getNode(destination));
        }

        private boolean hasPathBFS(Node source, Node destination) {
            LinkedList<Node> nextToVisit = new LinkedList<Node>();
            HashSet<Integer> visited = new HashSet<Integer>();
            nextToVisit.add(source);
            while(!nextToVisit.isEmpty()) {
                Node node = nextToVisit.remove();
                if (node == destination) {
                    return true;
                }
                if (visited.contains(node.id)) {
                    continue;
                }
                visited.add(node.id);
                for (Node child: node.adjacent) {
                    nextToVisit.add(child);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}