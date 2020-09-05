package akki.algos.graph;

import java.util.ArrayList;
import java.util.List;

public class PrimsAlgorithm {

	Node[] vertices;

	public static void main(String[] args) {
		String[] verticesString = { "Akhilesh", "Shuchita", "Hershu", "Rishu", "Sonali", "DK", "Ved" };
		MST mst=new MST();
		PrimsAlgorithm graph = new PrimsAlgorithm();
		graph.vertices=new Node[7];
		graph.setVertices(graph.addvertices(verticesString));
		graph.addEdge(0, 1,3);
		graph.addEdge(1, 6,5);
		graph.addEdge(5, 0,2);
		graph.addEdge(5, 2,7);
		graph.addEdge(5, 3,6);
		graph.addEdge(3, 4,4);
		graph.addEdge(0, 2,2);
		graph.addEdge(0, 3,5);
		mst.minimumSpanningTreePrimsAlgorithm(graph.vertices);
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
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public Node getNode1() {
			return node1;
		}
		public void setNode1(Node node1) {
			this.node1 = node1;
		}
		public Node getNode2() {
			return node2;
		}
		public void setNode2(Node node2) {
			this.node2 = node2;
		}
		Node node2;
		public Edge(int weight, Node node1, Node node2) {
			this.weight = weight;
			this.node1 = node1;
			this.node2 = node2;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((node1 == null) ? 0 : node1.hashCode());
			result = prime * result + ((node2 == null) ? 0 : node2.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (node1 == null) {
				if (other.node1 != null)
					return false;
			} else if (!node1.equals(other.node1))
				return false;
			if (node2 == null) {
				if (other.node2 != null)
					return false;
			} else if (!node2.equals(other.node2))
				return false;
			return true;
		}
		private PrimsAlgorithm getOuterType() {
			return PrimsAlgorithm.this;
		}
	}

	class Node implements Comparable<Node>{
		String name;
		List<Edge> adjacentEdges=new ArrayList<>();
		
		int weight=Integer.MAX_VALUE;
		
		boolean isVisited = false;

		public Node(String name) {
			super();
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
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
			return "Node [name=" + name + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.getWeight();
		}

		private PrimsAlgorithm getOuterType() {
			return PrimsAlgorithm.this;
		}
	}

	public Node[] getVertices() {
		return vertices;
	}

	public void setVertices(Node[] vertices) {
		this.vertices = vertices;
	}

}
