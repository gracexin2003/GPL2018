package GPL2018;

import java.util.*;

@SuppressWarnings ("resource")
public class C {

    public static void main(String[] args) {
    	
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++) sum += s.nextInt();
        System.out.println(sum/n);
        
    }
    
}