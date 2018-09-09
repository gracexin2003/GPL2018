package GPL2018;

import java.util.*;

@SuppressWarnings("resource")
public class F {

    static class Bomb implements Comparable<Bomb> {
        int index, time;
        public Bomb(int i, int t){
            index = i;
            time = t;
        }
        public int compareTo(Bomb b) {
            return time-b.time;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), S = s.nextInt();
        Bomb[] bombs = new Bomb[N];
        int[] mtns = new int[N];
        for(int i = 0; i < N; i++) bombs[i] = new Bomb(i+1, s.nextInt());
        for(int i = 0; i < N; i++) mtns[i] = s.nextInt();
        Arrays.sort(bombs);
        int[] diff = new int[N];
        boolean victory = true;
        for(int i = 0; i < N; i++) {
            diff[i] = bombs[i].time - S * i;
            if(diff[i] <= 0) {
                diff[i] = 0;
                victory = false;
                break;
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.print(diff[i] + " ");
        }
        for(int i = 0; i < N; i++) {
            System.out.print(bombs[i].index + " ");
        }
        if(victory) System.out.println("VIVE LA ROBO-LUTION");
        else System.out.println("IMPOSSIBLE");
        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(diff[i] == 0) break;
            sum += mtns[i];
        }
        System.out.println(sum);
    }

}