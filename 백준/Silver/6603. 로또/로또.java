import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int n;
	static boolean visited[];
	static int ans[] =new int[6];
	
	static void getNumbers(int dep, int start) {
		if(dep==6) {
			for(int i =0; i<6; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i =start+1; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ans[dep] = arr[i];
			getNumbers(dep+1, i);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			arr=new int[n];
			visited=new boolean[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				visited[i] = false;
			}
			
			getNumbers(0, -1);
			System.out.println();
		}
		br.close();
	}
}