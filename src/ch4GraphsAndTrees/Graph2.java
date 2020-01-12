package ch4GraphsAndTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph2 {
	private static class Vertex {
		String data = "";
		LinkedList<Vertex> adjList;
		boolean visited;
		
		public Vertex(String data) {
			this.data = data;
			adjList = new LinkedList<>();
			visited = false;
		}
		
		public void connectVertex(Vertex otherVertex, boolean bidirectional) {
			adjList.add(otherVertex);
			if(bidirectional)
				otherVertex.connectVertex(this, false);
		}
		
		@Override
		public String toString() {
			return data;
		}
		
		public String getAdjListAsStr() {
			return adjList.toString();
		}
	}
	
	private Map<String, Vertex> vertices;
	
	public Graph2() {
		vertices = new HashMap<>();
	}
	
	public void addEdge(String source, String destination) {
		addEdge(source, destination, false);
	}
	
	public void addEdge(String source, String destination, boolean bidirectional) {
		Vertex sourceVertex = vertices.get(source);
		Vertex endVertex = vertices.get(destination);
		
		if (sourceVertex == null) {
			sourceVertex = new Vertex(source);
			vertices.put(source, sourceVertex);
		}
		
		if (endVertex == null) {
			endVertex = new Vertex(destination);
			vertices.put(destination, endVertex);
		}
		
		sourceVertex.connectVertex(endVertex, bidirectional);
	}
	
	public void addVertex(String vertexName) {
		if(vertices.containsKey(vertexName))
			return;
		
		vertices.put(vertexName, new Vertex(vertexName));
	}
	
	
	public void depthFirstSearch(String startPoint, String wantedValue) {
		Vertex startVertex = vertices.get(startPoint);
		Vertex wantedVertex = vertices.get(wantedValue);
		
		if(startVertex == null)
			return;
		else if (wantedVertex == null)
			return;
		
		depthFirstSearch(startVertex, wantedVertex);
		
	}
	
	private void depthFirstSearch(Vertex root, Vertex wanted) {
		if (root == null)
			return;
		
		root.visited = true;
		System.out.print(root.data + " ");
		
		for (Vertex v : root.adjList) {
			if(!v.visited)
				depthFirstSearch(v, wanted);
		}
	}
	
	public boolean breadthFirstSearch(String startV, String wanted) {
		Vertex startVertex = vertices.get(startV);
		if(startVertex == null)
			return false;
		
		Queue<Vertex> queue = new LinkedList<>();
		startVertex.visited = true;
		queue.add(startVertex);
		
		while(!queue.isEmpty()) {
			Vertex v = queue.remove();
			if(v.data.equals(wanted))
				return true;
			
			for( Vertex neighbor: v.adjList ) {
				if( !neighbor.visited ) {
					neighbor.visited = true;
					if ( neighbor.data.equals(wanted) )
						return true;
					
					queue.add(neighbor);
				}
			} 
		}
		
		return false;
	}
	
	public void breadthFirstTrav(String vName) {
		Vertex startVertex = vertices.get(vName);
		if(startVertex == null)
			return;
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		startVertex.visited = true;
		queue.add(startVertex);
		
		while(!queue.isEmpty()) {
			Vertex currVertex = queue.remove();
			System.out.print(currVertex + " ");
			for( Vertex neighbor : currVertex.adjList ) {
				if ( !neighbor.visited ) {
					System.out.print(neighbor + " ");
					neighbor.visited = true;
					queue.add(neighbor);
				}
			}
			
			System.out.println();
				
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for( Vertex vertex : vertices.values() ) {
			builder.append(vertex.toString());
			builder.append(": ");
			builder.append(vertex.getAdjListAsStr());
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Graph2 graph = new Graph2();
		graph.addVertex("Bob");
		graph.addVertex("Alice");
		graph.addVertex("Mark");
		graph.addVertex("Rob");
		graph.addVertex("Maria");
		
		graph.addEdge("Bob", "Alice");
		graph.addEdge("Bob", "Rob");
		graph.addEdge("Alice", "Mark");
		graph.addEdge("Rob", "Mark");
		graph.addEdge("Alice", "Maria");
		graph.addEdge("Rob", "Maria");
		graph.addEdge("Mark", "Bob");
		
		System.out.println(graph);
		//graph.depthFirstSearch("Bob", "Maria");
		// graph.breadthFirstTrav("Bob");
		System.out.println("Bob -> Maria " + graph.breadthFirstSearch("Bob", "Maria"));
		
	}
}
