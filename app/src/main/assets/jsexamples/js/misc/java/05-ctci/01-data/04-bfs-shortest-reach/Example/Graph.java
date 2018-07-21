import java.util.*;

public class Graph {
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

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
		//System.out.println("Creating: " + id);
		n = new Node(id);
		nodeLookup.put(id, n);
		return n;
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
		//System.out.println("(" + source.id + ", " + destination.id + ")");
		if (visited.contains(source.id)) {
			return false;
		}
		//System.out.println("Adding: " + source.id);
		visited.add(source.id);
		if (source == destination)  {
			return true;
		}
		for (Node child: source.adjacent) {
			//System.out.println("Child: " + child.id);
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
		//System.out.println("(" + source.id + ", " + destination.id + ")");
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

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(1, 5);
		System.out.println(g.hasPathDFS(1, 4)); // true
		System.out.println(g.hasPathDFS(1, 6)); // false
		System.out.println(g.hasPathBFS(1, 4)); // true
		System.out.println(g.hasPathBFS(1, 6)); // false
	}
}