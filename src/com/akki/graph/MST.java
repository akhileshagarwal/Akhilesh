package com.akki.graph;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.akki.graph.PrimsAlgorithm.Edge;
import com.akki.graph.PrimsAlgorithm.Node;

public class MST {

	public void minimumSpanningTreePrimsAlgorithm(Node[] vertices){
		Queue<Node> prioQueue=new PriorityQueue<>();
		for(Node node:vertices){
			prioQueue.add(node);
		}
		Node[] parent=new Node[vertices.length];
		prioQueue.peek().setWeight(0);
		while(!prioQueue.isEmpty()){
			Node n=prioQueue.poll();
			System.out.println(n);
			List<Edge> adjacentEdges = n.getAdjacentNodes();
			for(Edge edge:adjacentEdges){
				int thisWeight=edge.getWeight();
				Node destination=edge.getNode2();
				int currentWeight=destination.getWeight();
				if(thisWeight<currentWeight){
					destination.setWeight(thisWeight);
				}
			}
		}
	}
}
