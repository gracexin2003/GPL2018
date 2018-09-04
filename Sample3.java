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
	
}