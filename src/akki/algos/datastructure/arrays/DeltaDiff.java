package akki.algos.datastructure.arrays;

public class DeltaDiff {
	public static void main(String[] args) {
		int length = args.length;
		int[] outputArr = new int[length * 2];
		int count = 1;
		outputArr[0] = Integer.parseInt(args[0]);
		for (int i = 0; i < length - 1; i++) {
			int diff = Integer.parseInt(args[i + 1]) - Integer.parseInt(args[i]);
			if (-127 > diff || diff > 128) {
				outputArr[count] = -128;
				count = count + 1;
			}
			outputArr[count] = diff;
			count++;
		}

		for (Integer num : outputArr) {
			if(num!=0){
			System.out.print(num + " ");
			}
		}

	}
}
