import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*

a and b are both initially greater than or equal to x and y respectively

1 operation: decrease either a or b
however, the max no. of operations is n

objective -> find the minimum product of a and b

there are two values to check:
1. use all of the n operations on a first, then on b
2. use all of the n operations on b first, then on a

choose the smaller value between the two

*/

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			long a = fs.nextInt(), b = fs.nextInt(), x = fs.nextInt(), y = fs.nextInt(), n = fs.nextInt();
			long newA = 0, newB = 0, newN = n;
			//a first
			newA = Math.max(a - newN, x);
			newN -= (a - newA);
			newB = Math.max(b - newN, y);
			long res = newA * newB;
			//b first
			newN = n;
			newB = Math.max(b - newN, y);
			newN -= (b - newB);
			newA = Math.max(a - newN, x);
			res = Math.min(res, newA * newB);
			out.println(res);
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
