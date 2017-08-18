package com.akki;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MaxOccurence {

	public static void main(String[] args) {
		ArrayList<String> seussCountActivities = new ArrayList<String>() { {
	        add("Alex");
	        add("Michael");
	        add("Harry");
	        add("Dave");
	        add("Michael");
	        add("Victor");
	        add("Harry");
	        add("Alex");
	        add("Marry");
	        add("Marry");
	    }};
	    String winner=null;
	    
	    Integer initialCount=0;
	    Map<String,Integer> map=new TreeMap<>();
	    for(String s:seussCountActivities){
	    	Integer count=map.get(s);
	    	if(count==null){
	    		count=1;
	    	}else{
	    	count+=1;
	    	}
	    	map.put(s, count);
	    }
	    System.out.println(map);
	    for(String s:map.keySet()){
	    	Integer i=map.get(s);
	    	if(initialCount<=i){
	    		initialCount=i;
	    		winner=s;
	    	}
	    }
	    System.out.println(winner);
	}

}
