import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] coin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coin = new int[n];
		
		for(int i =0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i =n-1; i>=0; i--) {
			if(coin[i]>k) continue;
			cnt += k/coin[i];
			k%=coin[i];
			if(k==0) break;
		}
		System.out.println(cnt);
		br.close();
	}
}