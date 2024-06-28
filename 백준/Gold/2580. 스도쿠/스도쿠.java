import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][] = new int[9][9];
	static boolean visited[];
	static int blank[][];
	
	static boolean line(int row, int col, int value) {
		for(int i =0; i<9; i++) {
			if(map[row][i] == value) return false;
			if(map[i][col] == value) return false;
		}
		return true;
	}
	
	static boolean square(int row, int col, int value) {
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void fillBlank(int col, int row) {
		if(col==9) {
			fillBlank(0, row+1);
			return;
		}
		
		if(row ==9) {
			for(int i =0; i<9; i++) {
				for(int j =0; j<9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(map[row][col] == 0) {
			for(int i =1; i<=9; i++) {
				if(line(row, col, i) && square(row, col, i)) {
					map[row][col]=i;
					fillBlank(col+1, row);
				}
			}
			map[row][col] = 0;
			return;
		}
		
		fillBlank(col+1, row);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i =0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		fillBlank(0, 0);
	}
}
