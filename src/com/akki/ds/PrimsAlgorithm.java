package com.akki.ds;

import java.util.ArrayList;
import java.util.List;

public class PrimsAlgorithm {

	Node[] vertices;

	public static void main(String[] args) {
		String[] verticesString = { "Akhilesh", "Shuchita", "Hershu", "Rishu", "Sonali", "DK", "Ved" };
		
		PrimsAlgorithm graph = new PrimsAlgorithm();
		graph.vertices=new Node[5];
		graph.setVertices(graph.addvertices(verticesString));
		graph.addEdge(0, 1,3);
		graph.addEdge(1, 6,5);
		graph.addEdge(5, 0,2);
		graph.addEdge(5, 2,7);
		graph.addEdge(5, 3,6);
		graph.addEdge(3, 4,4);
		graph.addEdge(0, 2,2);
		graph.addEdge(0, 3,5);
		//bfs.bfs(graph.vertices);
		//dfs.dfs(graph.vertices);
		//dfs.recursiveDFSUtil(graph.vertices);
	}

	void addEdge(int node1, int node2, int weight) {
		Edge edge=new Edge(weight, vertices[node1],vertices[node2]);
		vertices[node1].getAdjacentNodes().add(edge);
		vertices[node2].getAdjacentNodes().add(edge);
	}

	Node[] addvertices(String[] args) {
		for (int i = 0; i < args.length; i++) {
			vertices[i] = createNode(args[i]);
		}
		return vertices;
	}

	Node createNode(String name) {
		return new Node(name);
	}
	
	class Edge{
		int weight;
		Node node1;
		Node node2;
		public Edge(int weight, Node node1, Node node2) {
			this.weight = weight;
			this.node1 = node1;
			this.node2 = node2;
		}
	}

	class Node {
		String name;
		List<Edge> adjacentEdges=new ArrayList<>();
		
		int weight=Integer.MAX_VALUE;
		
		boolean isVisited = false;

		public Node(String name) {
			super();
			this.name = name;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Edge> getAdjacentNodes() {
			return adjacentEdges;
		}

		public void setAdjacentNodes(List<Edge> adjacentNodes) {
			this.adjacentEdges = adjacentNodes;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}

	public Node[] getVertices() {
		return vertices;
	}

	public void setVertices(Node[] vertices) {
		this.vertices = vertices;
	}

}
