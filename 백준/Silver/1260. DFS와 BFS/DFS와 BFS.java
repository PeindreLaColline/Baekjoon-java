import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v;
	static List<Integer>[] list;
	static boolean[] visited;
	
	static void dfs(int i) {
		visited[i] = true;
		System.out.print(i+" ");
		for(int j:list[i]) {
			if(!visited[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			System.out.print(i+" ");
			for(int j:list[i]) {
				if(!visited[j]) {
					visited[j] = true;
					q.offer(j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		list = new List[n+1]; for(int i =0; i<=n; i++) list[i] = new ArrayList<>();
		visited = new boolean[n+1];
		
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 0; i <= n; i++) {
		    Collections.sort(list[i]);
		}
		
		dfs(v);
		System.out.println();
		
		visited=new boolean[n+1];
		
		bfs(v);
	}
}
