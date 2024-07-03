import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int v, e;
	static boolean[] visited;
	static int[] w;
	static List<int[]>[] g;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		//init
		visited = new boolean[v+1];
		w = new int[v+1];
		for(int i =0; i<=v; i++) w[i] = Integer.MAX_VALUE;
		g = new List[v+1];
		for(int i =0; i<=v; i++) {
			g[i] = new ArrayList<>();
		}
		
		//input
		int a, b, c;
		for(int i =0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b, c});
			g[b].add(new int[] {a, c});
		}
		
		//process
		int sum =0, cnt=0;
		w[1] = 0;
		for(int i=1; i<=v; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex=-1;
			for(int j =1; j<=v; j++) {
				if(!visited[j] && min>w[j]) {
					min =w[j];
					minVertex=j;
				}
			}
			visited[minVertex] = true;
			sum += min;
			if(cnt++==v) break;
			
			for(int[] j: g[minVertex]) {
				if(!visited[j[0]] && w[j[0]]>j[1]) {
					w[j[0]] = j[1];
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}