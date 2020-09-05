package akki.algos.misc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {
	public static void main(String[] args) {
		List<Interval> list=new ArrayList<>();
		int currentExecutive=Integer.parseInt(args[0]);
		int count=Integer.parseInt(args[1]);
		for(int i=2;i<(count*2)+2;i=i+2){
			list.add(new Interval(Integer.parseInt(args[i]), Integer.parseInt(args[i+1])));
		}
		/*Interval i1=new Interval(1, 3);
		Interval i2=new Interval(1, 5);
		
		Interval i4=new Interval(6, 7);
		
		list.add(i4);
		
		list.add(i2);
		list.add(i1);*/
		int required= new OverlappingIntervals().merge(list);
		//results.forEach(System.out::println);
		System.out.println(required-currentExecutive);
	}

	 public int merge(List<Interval> list) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(list.size() == 0)
	            return 0;
	        if(list.size() == 1)
	            return 1;
	        int counter=0;
	        Collections.sort(list, new IntervalComparator());
	        
	        Interval first = list.get(0);
	        int start = first.start;
	        int end = first.end;
	        
	        ArrayList<Interval> result = new ArrayList<Interval>();
	        
	        for(int i = 1; i < list.size(); i++){
	            Interval current = list.get(i);
	            if(current.start <= end){
	                end = Math.max(current.end, end);
	                counter++;
	            }else{
	                result.add(new Interval(start, end));
	                start = current.start;
	                end = current.end;
	            }
	            
	        }
	        
	        result.add(new Interval(start, end));
	        
	        return counter;
	        
	    }
	}


	class IntervalComparator implements Comparator{
	        public int compare(Object o1, Object o2){
	            Interval i1 = (Interval)o1;
	            Interval i2 = (Interval)o2;
	            return i1.start - i2.start;
	        }
	}
	
	class Interval {
		     int start;
		     
			int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		      @Override
				public String toString() {
					return "Interval [start=" + start + ", end=" + end + "]";
				}
		  }