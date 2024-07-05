import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] loss;
	static int[] bene;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//input
		n = Integer.parseInt(br.readLine());
		loss = new int[n];
		bene = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			loss[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			bene[i] = Integer.parseInt(st.nextToken());
		}
		
		//process
		int[] dp = new int[101];
		for(int i =0; i<n; i++) {
			for(int l=99; l>0; l--) {
				if(loss[i]<=l) {
					dp[l] = Math.max(dp[l], bene[i]+dp[l-loss[i]]);
				}
			}
		}
		System.out.println(dp[99]);
		br.close();
	}
}