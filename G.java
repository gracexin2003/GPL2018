package GPL2018;

import java.util.*;

/*
4 8
0 0 0 0 0 0 0 0
0 0 2 0 0 0 1 0 
0 0 2 2 0 0 1 0 
3 0 0 0 0 0 0 0
*/

@SuppressWarnings ("resource")
public class G {

	public static int N, M;
	public static int[][] mat;
	public static double[] ratios;
	public static int area, perimeter;
	public static boolean[][] visited;
	public static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		N = s.nextInt(); M = s.nextInt();
		mat = new int[N][M]; ratios = new double[N*M+1];
		v = new boolean[N*M+1];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++)
				mat[i][j] = s.nextInt();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(v[mat[i][j]] || mat[i][j] == 0) continue;
				v[mat[i][j]] = true;
				area = 0; perimeter = 0;
				traverse(mat[i][j], i, j);
				ratios[mat[i][j]] = (double)perimeter/area;
			}
		}
		
		int ans = 0;
		double min = Integer.MAX_VALUE;
		for(int i = 1; i < N*M; i++) {
			if(ratios[i] == 0) break;
			if(ratios[i] < min) {
				min = ratios[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}
	
	public static void traverse(int x, int i, int j) {
		if(visited[i][j]) return;
		visited[i][j] = true;
		area++;
		boolean[] UDRL = new boolean[4];
		int sides = 0;
		if(i-1 >= 0 && mat[i-1][j] == x) {
			UDRL[0] = true;
			sides++;
		}
		if(i+1 < N && mat[i+1][j] == x) {
			UDRL[1] = true;
			sides++;
		}
		if(j-1 >= 0 && mat[i][j-1] == x) {
			UDRL[2] = true;
			sides++;
		}
		if(j+1 < M && mat[i][j+1] == x) {
			UDRL[3] = true;
			sides++;
		}
		perimeter += 4-sides;
		if(UDRL[0]) traverse(x, i-1, j);
		if(UDRL[1]) traverse(x, i+1, j);
		if(UDRL[2]) traverse(x, i, j-1);
		if(UDRL[3]) traverse(x, i, j+1);
		visited[i][j] = false;
	}
	
}
