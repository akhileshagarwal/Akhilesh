package com.akki.ds;

import java.util.Iterator;
import java.util.Stack;

import com.akki.ds.Graph.Node;

public class DFS {
	
	Stack<Node> stack=new Stack<>();
	
	void dfs(Node[] vertices) {
		stack.push(vertices[0]);
		while(!stack.isEmpty()){
			Node current = stack.pop();
			if(!current.isVisited()){
			current.setVisited(true);
			System.out.println(current);
			}
			Iterator<Node> it=current.getAdjacentNodes().iterator();
			while(it.hasNext()){
				Node adjacent=it.next();
				if(!adjacent.isVisited){
					stack.push(adjacent);
				}
			}
		}
	}
	
	void recursiveDFSUtil(Node[] vertices){
		recursiveDFS(vertices[0]);
	}
	
	private void recursiveDFS(Node current){
		
			current.setVisited(true);
			System.out.println(current);
			Iterator<Node> it=current.getAdjacentNodes().iterator();
			while(it.hasNext()){
				Node adjacent=it.next();
				if(!adjacent.isVisited){
					recursiveDFS(adjacent);
				}
		}
	
	}
}
