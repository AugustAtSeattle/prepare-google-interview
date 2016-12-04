package RouteBetweenNodes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;



// Question: Given a directed graph, design an algorithm to find out weather there is a route between two nodes.

enum State { Unvisited, Visited, Visiting;}

class Graph {
	public Node[] nodes;
}

class Node {
	public State state; 
	public String name;
	public Node[] neighbors;
}

public class Solution {


	
	public static void main(String[] args) {
		
	}
	//Solution 1 DFS
	boolean search1(Graph g, Node start, Node end){
		if(start == end) return true;
		
		Set<Node> set = new HashSet<Node>();
		return DFSSearch(start, end, set);
	}
	
	
	private boolean DFSSearch(Node start, Node end, Set<Node> set) {
		if(start == end) return true;
		if (set.contains(start)) return false;
		
		set.add(start);
		for(Node neighbor : start.neighbors){
			if(DFSSearch(neighbor, end, set) == true) return true;
		}
		return false;
	}
	
	//Solution 2 BFS
	boolean search2(Graph g, Node start, Node end){
		if(start == end) return true;
		
		// operates as a queue
		LinkedList<Node> queue = new LinkedList<Node>();
		
		//initalize 
		for(int i = 0 ; i < g.nodes.length; i++){
			Node node = g.nodes[i];
			node.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		queue.add(start);
		
		while(!queue.isEmpty()){
			Node node = queue.removeFirst();
			
			if (node == null){
				continue;
			}
			for(int i = 0; i < node.neighbors.length; i++){
				Node neighbor = node.neighbors[i];
				
				if (neighbor == null){
					continue;
				}
				
				if(neighbor.state == State.Unvisited){
					if(neighbor == end){
						return true;
					}else{
						neighbor.state = State.Visiting;
						queue.add(neighbor);
					}
				}
			}
			
			node.state = State.Visited;
		}
		
		return false;
	}

}
