package GPL2018;

import java.util.*;

@SuppressWarnings("resource")
public class Sample1 {

	public static int a = 0, b;
	public static String line;
	
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		line = s.nextLine().toLowerCase();
		if(!hasLetter()) {
			System.out.println("yes");
			return;
		}
		b = line.length()-1;
		if (checkP()) System.out.println("yes");
		else System.out.println("no");
		
	}
	
	public static boolean hasLetter () {
		for(int i = 0; i < line.length(); i++)
			if(isLetter(line.charAt(i))) return true;
		return false;
	}
	
	public static boolean checkP () {
		letter();
		while (a < b) {
			if (line.charAt(a) != line.charAt(b)) return false;
			a++; b--;
			letter();
		}
		return true;
	}
	
	public static void letter () {
		while (!isLetter(line.charAt(a))) a++;
		while (!isLetter(line.charAt(b))) b--;
	}
	
	public static boolean isLetter (char x) {
		// ASCII: 97 - 122
		return (97 <= x && x <= 122);
	}
	
}
