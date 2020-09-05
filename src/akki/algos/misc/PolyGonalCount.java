package akki.algos.misc;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class PolyGonalCount {
	enum Shape {
		Square, Rectangle, Other
	}

	private static Shape shape(int a, int b, int c, int d) {
		if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
			return Shape.Other;
		}

		if (a == b && b == c && c == d) {
			return Shape.Square;
		}

		if ((a == c && b == d) || (a==d && b==c) || (a==b && c==d)) {
			return Shape.Rectangle;
		}

		return Shape.Other;
	}

	public static void main(String[] args){
		Map<Shape, Integer> enumMap = new EnumMap<Shape, Integer>(Shape.class);
		enumMap.put(Shape.Other, 0);
		enumMap.put(Shape.Square, 0);
		enumMap.put(Shape.Rectangle, 0);
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String line=scanner.nextLine();
			String[] lineArray=line.split(" ");
			int a = Integer.parseInt(lineArray[0]);
			int b = Integer.parseInt(lineArray[1]);
			int c = Integer.parseInt(lineArray[2]);
			int d = Integer.parseInt(lineArray[3]);

			Shape shp = shape(a, b, c, d);
			enumMap.put(shp, enumMap.get(shp) + 1);

		}

		System.out.println(
				(enumMap.get(Shape.Square) + " " + enumMap.get(Shape.Rectangle) + " " + enumMap.get(Shape.Other)));
	}
}