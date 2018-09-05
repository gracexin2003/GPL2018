package GPL2018;

import java.util.*;

@SuppressWarnings ("resource")
public class Sample3 {
	
	public static int N, M;
	public static int[] dp = new int[100000];
	
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		for (int i = 1; i < 100000; i++) dp[i] = Integer.MIN_VALUE;
		N = s.nextInt(); M = s.nextInt();
		int w, c;
		for (int i = 0; i < N; i++){
			w = s.nextInt(); c = s.nextInt();
			for (int j = 100000 - w - 1; j >= 0; j--)
				if (dp[j] != Integer.MIN_VALUE)
					dp[j + w] = Math.max(dp[j + w], dp[j] - c);
		}
		for (int i = 0; i < M; i++) {
			w = s.nextInt(); c = s.nextInt();
			for (int j = w; j < 100000; j++)
				if (dp[j] != Integer.MIN_VALUE)
					dp[j - w] = Math.max(dp[j - w], dp[j] + c);
		}
		int ans = 0;
		for (int i = 0; i < 100000; i++) ans = Math.max(ans, dp[i]);
		System.out.println(ans);
		
	}
	
/*
The key of Dynamic Programming (or DP) is to save calculated results in an array for future use directly.

The critical point is to store value (or '-cost') for each weight. 
The max weight is 100,000. 
So the size of DP array is 100,000.

Without Dynamic Programming (DP), we have to list all combinations of Engines and Asteroids. 
Since Engine has cost or negative value, same as Asteroids, we just talk about one type first, say Engine.
(1) If we have one Engine A, that is only one combination, A.
(2) If we add one more Engine, B, we have 3 combinations A, B, and AB
(3) If we add one more Engine C, we have the following, 
A, B, AB  (Already calculated and stored in the DP array using total weight as index)
C, AC, BC, ABC (Those are new. They are C itself and C plus each of existing indexes)
 
# So the protocol is, for each Engine, add the value (negative cost) at index of its weight and 
xsum the value with each of existing weight(index) in the DP array.

Repeat the steps above:
(1) Only DP[Wa} = -Ca (negative Cost of a) is added to the array at index Wa (Weight of A);
(2) DP[Wb] plus (the sum of DP[Wa] - Cost of B at index Wa+Wb (or Wab); DP[Wab] are saved for future use.
(3) DP[Wc] plus DP[Wc+Wa], DP[Wc+Wb], DP[Wc+Wab] (or Wabc) are added to the array. DP[Wabc] = DP[Wc] + DP[Wab], 
one addition only.

# To implement the above protocol, we initialize each elelment of the DP array to an impossible value. 
For each item (Engine), add itself first. 
Then sum itself to all elements with (Not impossible value).  
(100000 times' checks, that is the size of DP array)
The total time will be number of items times the size of DP array.

# For duplicated indexes, pick the highest value. Say A[W=1, C=10], B{W=1, C=6], C[W=2, C=2]; Repeat the steps above.
(1) DP[1] = -10
(2) DP[1] = -6 (Replace the -10 in step-1; DP[2] = -16;  After step-2, only 2 Not-Impossilbe values;
(3) DP[1] = -10 remains. DP[2] = -2 (Replace -16 in step-2), DP[3] = DP[1] + DP[2] = -10 + (-2) = -12;
  
# Now add Asteroids. The protocol is the same. 
Asteroid's weight must be less than the weight of total weight of Engines. 
We use negative value for the weight of Asteroid. For example, after the steps above, we have an asteroid [W=2, V=10].

This Asteroid can not be added to DP[1] in which the total weight of Engine is only 1, 
less than the weight of this Asteroid.
It can be added to DP[2], to make DP[2-2] = DP[0] = 10-2 = 8, and no more Asteroid to this element;
It also can be added to DP[3] to make DP[3-2] = DP[1] = 10-12 = -2. 
You can add one more Asteroid at Weight 1 to this element.

# For duplicated indexes, pick the highest value.

# After adding all Engines and Asteroids, the max value in the DP array is the answer.
Total time is (N+M)*100,000
 */
	
}