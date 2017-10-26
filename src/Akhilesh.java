import java.io.IOException;
import java.util.function.Function;

public class Akhilesh {
	public static void main(String[] args){
		
		
		try {
			Function<String,Integer> cons= s->{
				try {
					throw new IOException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return s.length();
			};
			System.out.println(cons.apply("akhilesh"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
