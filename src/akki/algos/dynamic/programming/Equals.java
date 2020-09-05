package akki.algos.dynamic.programming;

public class Equals {

	// this function returns the number of
	// arrangements to form 'n'
	public static int MAXN = 1000;
	int dp[] = new int[MAXN];

	int solve(int n) {
		// initialize to -1

		// base case
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		// checking if already calculated
		if (dp[n] != -1)
			return dp[n];

		// storing the result and returning
		return dp[n] = solve(n - 1) + solve(n - 2) + solve(n - 5);
	}

	public static void main(String[] args) {
		Equals equals = new Equals();
		for (int i = 0; i < MAXN; i++) {
			equals.dp[i] = -1;
		}
		int count = equals.solve(4);
		System.out.println(count);
	}
}
