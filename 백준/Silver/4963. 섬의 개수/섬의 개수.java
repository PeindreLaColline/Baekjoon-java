import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;

	static int w, h;

	static void dfs(int x, int y) {
		visited[y][x] = true;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx]==1 && !visited[ny][nx]) {
				dfs(nx, ny);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			int island = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0; i<h; i++) {
				for(int j =0; j<w; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						island++;
						dfs(j, i);
					}
				}
			}
			System.out.println(island);
		}
		br.close();
	}
}
