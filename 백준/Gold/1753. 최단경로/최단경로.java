import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int v, e, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		
		List<int[]>[] g = new List[v+1];
		for(int i =0; i<v+1; i++) g[i] = new ArrayList<>();
		
		int from, to, weight;
		for(int i =0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, weight});
		}
		boolean[] visited = new boolean[v+1];
		int[] dist = new int[v+1];
		for(int i =0; i<v+1; i++) dist[i] = Integer.MAX_VALUE;
		
		dist[k] = 0;
		for(int i =1; i<=v; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int j =1; j<=v; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			
			for(int[] j:g[minVertex]) {
				if(!visited[j[0]] && dist[j[0]]>min+j[1]) {
					dist[j[0]] = min + j[1];
				}
			}
		}
		for(int i =1; i<=v; i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		br.close();
	}
}