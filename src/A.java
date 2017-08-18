import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class A {
		
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");
		list.add("perl");
		list.add("c");
		list.add("lisp");
		list.add("c#");
		Stream<String> wordStream = list.stream();
		System.out.println(wordStream.map(String::length).mapToInt(Integer::new).sum());
		Stream<Integer> lengthStream = list.stream().map(String::length);
		
		Optional<Integer> sum = lengthStream.reduce((x, y) -> x + y);
		
		sum.ifPresent(System.out::println);
		
		Optional<Integer> sum1 = lengthStream.reduce(Integer::sum);
		sum1.ifPresent(System.out::println);
	}
}
