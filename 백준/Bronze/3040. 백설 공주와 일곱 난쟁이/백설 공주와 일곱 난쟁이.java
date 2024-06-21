import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] troll = new int[9];
	static boolean[] v = new boolean[9];
	static boolean done = false;
	
	private static void cherche(int cnt, int val, int s) {
		if(cnt == 7
				) {
			if(val == 100) {
				for(int i =0; i<9; i++) {
					if(v[i]) {
						System.out.println(troll[i]);
					}
				}
				done = true;
				return;
			}
		}
		
		for(int i =s; i<9; i++) {
			if(done) return;
			if(v[i]) continue;
			v[i] =true;
			cherche(cnt+1, val+troll[i], i+1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i<9; i++) {
			troll[i] = Integer.parseInt(br.readLine().trim());
		}
		
		cherche(0, 0, 0);
		
	}
}
