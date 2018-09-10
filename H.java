package GPL2018;

import java.util.*;

// RADIX SORT!!!

@SuppressWarnings ("resource")
public class H {

	// A function to do counting sort of arr[] according to the digit represented by exp.
	static void countSort(Number arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i, count[] = new int[10];
		Number[] clone = arr.clone();
		// Store count of occurrences in count[]
		for (i = 0; i < n; i++) count[(arr[i].padded/exp)%10]++;
		// Change count[i] so that count[i] now contains actual position of this digit in output[]
		for (i = 1; i < 10; i++) count[i] += count[i - 1];
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i].padded/exp)%10] - 1] = i;
			count[(arr[i].padded/exp)%10]--;
		}
		// Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
		for (i = 0; i < n; i++) arr[i] = clone[output[i]];
	}

	// The main function to that sorts arr[] of size n using Radix Sort
	static void radixsort(Number arr[], int n) {
		// Find the maximum number to know number of digits
		int m = arr[0].padded;
		for (int i = 1; i < n; i++) if (arr[i].padded > m) m = arr[i].padded;
		// Do counting sort for every digit. (exp) is passed instead of the digit number.
		// (exp) is 10^i, where i is the current digit number.
		for (int exp = 1; m/exp > 0; exp *= 10) countSort(arr, n, exp);
	}
    
    //radixsort(arr, n);
	
	static class Number implements Comparable<Number> {
		int real, padded;
		public Number(int r, int pad) {
			real = r; padded = pad;
		}
		public int compareTo(Number n) {
			return padded-n.padded;
		}
	}
	
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); Number[] arr = new Number[N];
		for (int i = 0; i < N; i++) {
			int realNum = s.nextInt();
			int padded = realNum;
			int digits = 0, lastD = padded%10;
			for (int j = 1; padded/j > 0; j*=10) digits++;
			for (int j = digits; j < 9; j++) padded = padded*10+lastD;
			if(lastD<realNum/Math.pow(10, digits)) padded = padded*10+(9-digits);
			else padded = padded*10+digits;
			arr[i] = new Number(realNum, padded);
		}
		radixsort(arr, N);
		
		for (int i = 0; i < N; i++) System.out.println(arr[i].padded);
		
		for (int i = 0; i < N; i++) System.out.print(arr[i].real);
		System.out.println();
		for (int i = N-1; i >= 0; i--) System.out.print(arr[i].real);
		System.out.println();
		
	}
	
}
