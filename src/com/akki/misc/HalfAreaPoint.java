package com.akki.misc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HalfAreaPoint {
	
	List<Double> list = new ArrayList<>();
	public double findHalfAreaPoint(Curve curve, double p) {
		// YOUR CODE HERE
			return calculateArea(curve, curve.areaUnderCurve(p),0, p);
	}
	
	double calculateArea(Curve curve,double area,double m,double n){
		double p=(Math.round((m+n)/2*1000))/1000D;
		if(list.contains(p)){
			return list.get(list.size()-1);
		}else{
		list.add(p);
		}
		if(curve.areaUnderCurve(p)*2==area){
			return p;
		}
		if(curve.areaUnderCurve(p)*2<area){
			return calculateArea(curve, area,p, n);
		}else{
			return calculateArea(curve, area, m, p);
		}
	}
	
	

    // DO NOT MODIFY CODE BELOW THIS LINE
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Curve c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "EXP":
				c = new Exp();
				break;
			case "POWER":
				c = new Power(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			HalfAreaPoint t=new HalfAreaPoint();
			double p = 10.0d;
			double h = t.findHalfAreaPoint(c, p);
			System.out.println(Math.round(h*1000d));
		}

		scanner.close();
	}
}

	interface Curve {
		double areaUnderCurve(double x);
	}

	class Line implements Curve {
		private double m;
		private double c;

		public Line(double m, double c) {
			this.m = m;
			this.c = c;
		}

		@Override
		public double areaUnderCurve(double x) {
			return m * x + c;
		}
	}

	class Exp implements Curve {
		@Override
		public double areaUnderCurve(double x) {
			return Math.exp(x);
		}
	}

	class Power implements Curve {
		private double power;

		public Power(double power) {
			this.power = power;
		}

		@Override
		public double areaUnderCurve(double x) {
			return Math.pow(x, power);
		}
	}