package GPL2018;

import java.util.Scanner;

@SuppressWarnings ("resource")
public class D {

    public static void main(String[] args) throws Exception {
    	
        int n, m;
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); m = s.nextInt();
        //same column, row-1
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = s.nextInt();
                arr[i][j] = x;
                if (x == 7) {
                    System.out.println(arr[i-1][j]);
                    return;
                }
            }
        }
        
    }

}