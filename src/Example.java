import java.util.HashMap;
import java.util.Map;

public class Example {
	
public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<>();
	map.put("A", 1);
	map.put("B", 2);
	map.put("C", 3);
	 
	
}

static void computeExample(Map<String, Integer> map){
	// Compute a new value for the existing key
		System.out.println(map.compute("A", 
		    (k, v) -> v == null ? 42 : v + 41));
		System.out.println(map);
		 
		// This will add a new (key, value) pair
		System.out.println(map.compute("X", 
		    (k, v) -> v == null ? 42 : v + 41));
		System.out.println(map);
}
}


