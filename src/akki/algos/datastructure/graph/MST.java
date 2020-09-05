package akki.algos.graph;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST {

	public void minimumSpanningTreePrimsAlgorithm(PrimsAlgorithm.Node[] vertices){
		Queue<PrimsAlgorithm.Node> prioQueue=new PriorityQueue<>();
		for(PrimsAlgorithm.Node node:vertices){
			prioQueue.add(node);
		}
		PrimsAlgorithm.Node[] parent=new PrimsAlgorithm.Node[vertices.length];
		prioQueue.peek().setWeight(0);
		while(!prioQueue.isEmpty()){
			PrimsAlgorithm.Node n=prioQueue.poll();
			System.out.println(n);
			List<PrimsAlgorithm.Edge> adjacentEdges = n.getAdjacentNodes();
			for(PrimsAlgorithm.Edge edge:adjacentEdges){
				int thisWeight=edge.getWeight();
				PrimsAlgorithm.Node destination=edge.getNode2();
				int currentWeight=destination.getWeight();
				if(thisWeight<currentWeight){
					destination.setWeight(thisWeight);
				}
			}
		}
	}
}
