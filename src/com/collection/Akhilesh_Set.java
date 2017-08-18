package com.collection;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Executors;

public class Akhilesh_Set {
	public static void main(String[] args) {
		Queue priorityQueue=new PriorityQueue();
		priorityQueue.add("Shuchita");
		priorityQueue.add("Xkhilesh");
		priorityQueue.add("Agarwal");
		priorityQueue.add("Khurana");
		priorityQueue.add("Agarwal");
		System.out.println(priorityQueue);
		SortedSet<String> set=new TreeSet<>();
		set.addAll(priorityQueue);
		System.out.println(set);
		System.out.println(set.subSet("Khurana", "Xkhilesh"+"\0"));
		
		
	}
}
