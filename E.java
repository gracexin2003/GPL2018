package GPL2018;

import java.util.Scanner;

@SuppressWarnings ("resource")
public class E {

    public static void main(String[] args) throws Exception {
    	
        int n, m;
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); m = s.nextInt();
        int[] arr = new int[n];
        char x;
        int a, b;
        for(int i = 0; i < m; i++) {
            x = s.next().charAt(0);
            a = s.nextInt(); b = s.nextInt();
            if(x == 'A') for (int j = a-1; j < b; j++) arr[j] = 1;
            else for(int j = a; j < b+1 && j < arr.length; j++) arr[j] = 0;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i]>0) ans++;
        System.out.println(ans);
        
    }

}