import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] g;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//num of inputs
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new List[N+1]; for(int i =1; i<N+1; i++) g[i]=new ArrayList<>();
		indegree=new int[N+1];
		
		//processing input
		int a, b;
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			indegree[b]++;
		}
		
		bfs();
		br.close();
	}
	
	static void bfs() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1; i<N+1; i++) {
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		
		while(!q.isEmpty()) {
			int i=q.poll();
			System.out.print(i+" ");
			for(int j:g[i]) {
				if(--indegree[j]==0) q.offer(j);
			}
		}
	}
}
