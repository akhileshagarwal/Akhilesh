package com.akki.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	Node[] vertices;

	public static void main(String[] args) {
		String[] verticesString = { "Akhilesh", "Shuchita", "Hershu", "Rishu", "Sonali", "DK", "Ved" };
		
		Graph graph = new Graph();
		graph.vertices=new Node[verticesString.length];
		BFS bfs=new BFS();
		DFS dfs=new DFS();
		graph.addvertices(verticesString);
		graph.addEdge(0, 1);
		graph.addEdge(1, 6);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);
		graph.addEdge(5, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		//bfs.bfs(graph.vertices);
		//dfs.dfs(graph.vertices);
		dfs.recursiveDFSUtil(graph.vertices);
	}

	void addEdge(int node1, int node2) {
		vertices[node1].getAdjacentNodes().add(vertices[node2]);
		vertices[node2].getAdjacentNodes().add(vertices[node1]);
	}

	void addvertices(String[] args) {
		for (int i = 0; i < args.length; i++) {
			this.vertices[i] = createNode(args[i]);
		}
	}

	Node createNode(String name) {
		return new Node(name);
	}

	class Node {
		String name;
		List<Node> adjacentNodes=new ArrayList<>();
		boolean isVisited = false;

		public Node(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Node> getAdjacentNodes() {
			return adjacentNodes;
		}

		public void setAdjacentNodes(List<Node> adjacentNodes) {
			this.adjacentNodes = adjacentNodes;
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
