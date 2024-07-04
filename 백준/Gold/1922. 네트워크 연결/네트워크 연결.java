import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<int[]> [] g;
	static boolean[] visited;
	static int[] w;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		g = new List[n+1];
		for(int i =0; i<=n; i++) g[i] = new ArrayList<>();
		visited = new boolean[n+1];
		w = new int[n+1];
		for(int i =0; i<=n; i++) w[i] = Integer.MAX_VALUE;
		
		int a, b, c;
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b, c});
			g[b].add(new int[] {a, c});
		}
	
		int sum=0, cnt = 0;
		w[1] = 0;
		int min, minVertex;
		for(int i =1; i<=n; i++) {
			min = Integer.MAX_VALUE;
			minVertex = 0;
			for(int j =1; j<=n; j++) {
				if(!visited[j] && min>w[j]) {
					min= w[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			sum+=min;
			if(cnt++==n) break;
			
			for(int j[]: g[minVertex]) {
				if(!visited[j[0]] && w[j[0]] > j[1]) {
					w[j[0]] = j[1];
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
