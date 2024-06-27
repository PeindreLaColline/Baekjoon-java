import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c;
	static int ans = 0;
	
	static void get_z(int x, int y, int size) {
		if(c==x && r==y) {
			System.out.println(ans);
			return;
		}
		if(c<x + size && r<y+size && c>=x && r>=y) {
			size /= 2;
			get_z(x, y, size);
			get_z(x+size, y, size);
			get_z(x, y+size, size);
			get_z(x+size, y+size, size);
		}
		else {
			ans += size*size;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int tmp =  (int)Math.pow(2, n);
		
		get_z(0, 0, tmp);
		
		br.close();
	}
}
