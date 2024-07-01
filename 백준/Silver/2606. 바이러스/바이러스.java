import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<Integer>[] com;
	static boolean visited[];
	
	static int ans = 0;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			ans++;
			for(int j:com[i]) {
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

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		com = new List[n+1]; for(int i =0; i<=n; i++) com[i] = new ArrayList<>();
		visited = new boolean[n+1];
		
		int from, to;
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			com[from].add(to);
			com[to].add(from);
		}
		
		bfs(1);
		System.out.println(--ans);
		
		br.close();
	}
	
}
