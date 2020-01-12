package ch4GraphsAndTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	private Map<T, List<T> > map = new HashMap<>();
	
	
	public void addVertex(T s) {
		map.put(s, new LinkedList<T>());
	}
	
	public void addEdge(T source, T destination, boolean bidirectional) {
		if(!map.containsKey(source))
			addVertex(source);
		
		if(!map.containsKey(destination))
			addVertex(destination);
		
		map.get(source).add(destination);
		if(bidirectional)
			map.get(destination).add(source);
	}
	
	public int printVertexCounts() {
		return map.keySet().size();
	}
	
	public int edgeCount(boolean bidirectional) {
		int count = 0;
		for(T vertex: map.keySet())
			count += map.get(vertex).size();
		
		if(bidirectional)
			count /= 2;
		
		return count;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for( T vertex : map.keySet() ) {
			builder.append(vertex.toString());
			builder.append( ": ");
			for ( T w: map.get(vertex) ) {
				builder.append(w.toString());
				builder.append(" ");
			}
			
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		
		Graph<Integer> graph = new Graph<>();
		graph.addEdge(0, 1, true);
		graph.addEdge(0, 4, true);
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(1, 4, true);
		graph.addEdge(3, 4, true);
		
		System.out.println(graph);
		
	}
}
