import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int cours[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		cours = new int[n][2];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			cours[i][0] = Integer.parseInt(st.nextToken());
			cours[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cours, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0]-b[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(cours[0][1]);
		for(int i =1; i<n; i++) {
			if(cours[i][0] >= pq.element()) pq.poll();
			pq.offer(cours[i][1]);
		}
		System.out.println(pq.size());
	}
}
