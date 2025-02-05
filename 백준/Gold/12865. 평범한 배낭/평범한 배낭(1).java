import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] weight, value;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		weight = new int[n];
		value = new int[n];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[k+1];
		for(int i =0; i<n; i++) {
			for(int j=k; j>=1; j--) {
				if(weight[i]<=j) {
					dp[j] = Math.max(dp[j], value[i]+dp[j-weight[i]]);
				}
			}
		}
		System.out.println(dp[k]);
		br.close();
	}
}
