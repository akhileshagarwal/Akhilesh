package akki.algos.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import akki.algos.graph.Graph.Node;

public class BFS {
	Queue<Node> queue=new LinkedList<>();

	void bfs(Node[] vertices){
		Node n=vertices[0];
		n.setVisited(true);
		queue.add(n);
		System.out.println(n);
		while(!queue.isEmpty()){
			Node current=queue.poll();
			Iterator<Node> it=current.getAdjacentNodes().iterator();
			while(it.hasNext()){
				Node next=it.next();
				if(next.isVisited==Boolean.FALSE){
					next.setVisited(true);
					System.out.println(next);
					queue.add(next);
				}
			}
		}
		
	}

}
