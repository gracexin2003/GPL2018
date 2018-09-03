package GPL2018;

import java.util.*;

@SuppressWarnings ("resource")
public class Sample2 {

	public static int N, K;
	public static int[] H;
	
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		N = s.nextInt(); K = s.nextInt(); H = new int[N];
		for (int i = 0; i < N; i++) H[i] = s.nextInt();
		int max = 1, amt = 1;
		for (int i = 1; i < N; i++) {
			if(Math.abs(H[i]-H[i-1]) <= K) amt++;
			else {
				max = Math.max(max, amt);
				amt = 1;
			}
		}
		max = Math.max(max, amt);
		System.out.println(max);
		
	}
	
}
