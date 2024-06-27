import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	
	static int blue = 0, white = 0;
	
	static boolean color_check(int row, int col, int s) {
		int tmp = map[col][row];
		for(int i = col; i<col+s; i++) {
			for(int j = row; j<row+s; j++) {
				if(map[i][j] != tmp) return false;
			}
		}
		return true;		
	}
	
	static void recursive(int row, int col, int s) {
		if(color_check(row, col, s)) {
			if(map[col][row] == 0) white++;
			else blue++;
			return;
		}
		
		s/=2;
		
		recursive(row,col,s); //1
		recursive(row, col+s,s); //2
		recursive(row+s, col, s); //3
		recursive(row+s, col+s, s); //4
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
		
	}
}
