import java.util.*;

class Graph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();

        private Node(int id) {
            this.id = id;
        }

        public String toString() {
        	String str = "[";
	    	for (Node child : this.adjacent) {
	    		str += " " + child.id;
	    	}
        	return str +" ]";
        }
    }

	private void print() {
		System.out.println(nodeLookup);
	}

    private Node getNode(int id) {
    	Node node = nodeLookup.get(id);
    	if (node == null) {
    		node = new Node(id);
    		nodeLookup.put(id, node);
    	}
        return node;
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
    	if (visited.contains(source.id)) {
    		return false;
    	}
    	visited.add(source.id);
    	if (source == destination) {
    		return true;
    	}
    	for (Node child : source.adjacent) {
    		if (hasPathDFS(child, destination, visited)) {
    			return true;
    		}
    	}
    	return false;
    }

    public boolean hasPathBFS(int source, int destination) {
    	return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
    	LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
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

    public static void main(String[] args) {
    	System.out.println("Building graph...");

    	Graph g = new Graph();
    	g.addEdge(1, 2);
    	g.addEdge(1, 3);
    	g.addEdge(1, 4);
    	g.addEdge(1, 6);
    	g.addEdge(4, 6);
    	g.addEdge(6, 5);
    	g.addEdge(6, 8);
    	g.addEdge(8, 7);
    	g.print();
    	System.out.println("DFS(1,8): " + g.hasPathDFS(1, 8)); // true
    	System.out.println("BFS(1,8): " + g.hasPathBFS(1, 8)); // true
    	System.out.println("DFS(5,8): " + g.hasPathDFS(1, 8)); // false
    	System.out.println("BFS(5,8): " + g.hasPathBFS(1, 8)); // false
    	System.out.println("DFS(6,7): " + g.hasPathDFS(1, 8)); // true
    	System.out.println("BFS(6,7): " + g.hasPathBFS(1, 8)); // true
    }
}