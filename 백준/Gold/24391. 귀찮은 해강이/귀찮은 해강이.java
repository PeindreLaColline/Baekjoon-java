import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] p;
	static int ans;
	
	static void make() {
		p=new int[n+1];
		for(int i =0; i<=n; i++) {
			p[i]=i;
		}
	}
	
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		make();
		
		int a, b;
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		for(int i =1; i<=n; i++) {
			find(i);
		}
		
		int from, to;
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		for(int i=0; i<n-1; i++) {
			to = Integer.parseInt(st.nextToken());
			if(p[from] != p[to]) ans++;	
			from = to;
		}
		
		System.out.println(ans);
		
		br.close();
	}
}
