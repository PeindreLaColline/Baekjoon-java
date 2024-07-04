import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int testCase =1;
	static int n;
	static int[][] map;
	static int[][] cost;
	static boolean[][] visited;
	static int[][] dir = {{0, -1},{1, 0},{0, 1},{-1, 0}};
	static List<int[]>[] g;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			//input init
			n = Integer.parseInt(br.readLine());
			if(n== 0) break;
			map = new int[n][n];
			cost = new int[n][n];
			visited = new boolean[n][n];
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//process
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1[2], o2[2]));
			cost[0][0] = map[0][0];
			pq.offer(new int[] {0, 0, cost[0][0]});
			while(!pq.isEmpty()) {
				int[] vc=pq.poll();
				int min = vc[2];
				int minx = vc[0];
				int miny = vc[1];
				
				int nx, ny;
				for(int i = 0; i<4; i++) {
					nx = minx + dir[i][0];
					ny = miny + dir[i][1];
					if(0<=nx&&nx<n&&0<=ny&&ny<n) {
						if(cost[ny][nx] > min+map[ny][nx]) {
							cost[ny][nx] = min+map[ny][nx];
							pq.offer(new int[] {nx, ny, cost[ny][nx]});
						}
					}
				}
			}
			System.out.println("Problem " + testCase + ": " +cost[n-1][n-1]);
			testCase++;
		}
		br.close();
	}
}
