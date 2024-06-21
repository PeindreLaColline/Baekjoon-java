import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] taste;
	static int ans = 98765432;
	
	private static void subs(int sour, int bitter, int ind, boolean use) {
		if(ind == n) {
			if(!use) return;
			if(ans>Math.abs(sour-bitter)) ans = Math.abs(sour-bitter);
			return;
		}
		
		subs(sour*taste[ind][0], bitter+taste[ind][1], ind+1, true);
		subs(sour, bitter, ind+1, use);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine());
		taste = new int[n][2];
		
		for(int i =0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			taste[i][0] = Integer.parseInt(st.nextToken()); //sour
			taste[i][1] = Integer.parseInt(st.nextToken()); //bitter
		}
		
		subs(1, 0, 0, false);
		System.out.println(ans);
		
		br.close();
	}
}
