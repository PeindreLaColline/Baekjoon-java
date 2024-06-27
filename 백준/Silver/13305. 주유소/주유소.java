import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long [] road;
	static long[] oil;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n= Integer.parseInt(br.readLine());
		
		road = new long[n];
		oil = new long[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i =1; i<n; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0; i<n; i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}
		
		long cheapest = oil[0];
		long dis = 0;
		long cost = oil[0]*road[0];
		
		for(int i =0; i<n-1; i++) {
			dis += road[i+1];
			if(cheapest > oil[i+1]) {
				cost += dis *cheapest;
				dis = 0;
				cheapest = oil[i+1];
			}
		}
		cost += dis *cheapest;
		
		System.out.println(cost);
		
		br.close();
	}
}
