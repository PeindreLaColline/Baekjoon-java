import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[]a;
	static int[]b;
	static boolean[] v;
	private static void combi(int cnt, int start) {
		if(cnt == m) {
			for(int i =0; i<m; i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<n; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt]=a[i];
			combi(cnt+1, i+1);
			v[i]=false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st=new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		b = new int[m];
		v = new boolean[n];
		for(int i = 1; i<=n; i++) {
			a[i-1] = i;
			v[i-1] = false;
		}
		combi(0, 0);
	}
}
