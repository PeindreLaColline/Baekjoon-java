import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ver[] = new int[6];
	static int hor[] = new int[6];
	static int left =0;
	static int right = 0;
	static int x[] = new int[26];
	static int y[] = new int[26];
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num;
		for(int i =1; i<=5; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j =1; j<=5; j++) {
				num = Integer.parseInt(st.nextToken());
				x[num] = j;
				y[num] = i;
			}
		}
		 
		boolean done = false;
		
		int time =0;
		for(int i =1; i<=5; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j =1; j<=5; j++) {
				num = Integer.parseInt(st.nextToken());
				if(done) continue;
				time++;
				
				hor[x[num]]++;
				if(hor[x[num]]==5) ans++;
				
				ver[y[num]]++;
				if(ver[y[num]]==5) ans++;
				
				if(x[num]==y[num]) {
					right++;
					if(right == 5) ans++;
					
				}
				
				if(x[num] + y[num] == 6) {
					left++;
					if(left == 5) ans++;
				}
				
				if(ans>=3) {
					System.out.println(time);
					done = true;
				}
			}

		}
		br.close();
	}
}
