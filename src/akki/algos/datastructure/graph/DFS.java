package akki.algos.graph;

import java.util.Iterator;
import java.util.Stack;

public class DFS {
	
	Stack<Graph.Node> stack=new Stack<>();
	
	void dfs(Graph.Node[] vertices) {
		stack.push(vertices[0]);
		while(!stack.isEmpty()){
			Graph.Node current = stack.pop();
			if(!current.isVisited()){
			current.setVisited(true);
			System.out.println(current);
			}
			Iterator<Graph.Node> it=current.getAdjacentNodes().iterator();
			while(it.hasNext()){
				Graph.Node adjacent=it.next();
				if(!adjacent.isVisited){
					stack.push(adjacent);
				}
			}
		}
	}
	
	void recursiveDFSUtil(Graph.Node[] vertices){
		recursiveDFS(vertices[0]);
	}
	
	private void recursiveDFS(Graph.Node current){
		
			current.setVisited(true);
			System.out.println(current);
			Iterator<Graph.Node> it=current.getAdjacentNodes().iterator();
			while(it.hasNext()){
				Graph.Node adjacent=it.next();
				if(!adjacent.isVisited){
					recursiveDFS(adjacent);
				}
		}
	
	}
}
