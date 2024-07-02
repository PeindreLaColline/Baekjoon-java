import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] price;
	static int[] parent;
	static int[] cycle;
	
	static int ans = 0;
	
	static void make() {
		parent = new int[n+1];
		for(int i =1; i<n+1; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void unite(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if(ar==br) return;
		parent[br] = ar;
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		price = new int[n+1];
		cycle = new int[n+1];
		make();
		
		st = new StringTokenizer(br.readLine());
		for(int i =1; i<=n; i++) {
			price[i] = Integer.parseInt(st.nextToken());	
		}
		
		int a, b;
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			unite(a, b);
		}
		
		for(int i=1; i<=n; i++) {
			find(i);
		}
		
		for(int i =1; i<=n; i++) {
			if(cycle[parent[i]] == 0) {
				cycle[parent[i]]=price[i];
				continue;
			}
			else if(cycle[parent[i]]>price[i]) {
				cycle[parent[i]]=price[i];
			}
		}
		
		for(int i =1; i<=n; i++) {
			if(cycle[i] != 0) {
				ans += cycle[i];
			}
		}
		
		if(ans > k) {
			System.out.println("Oh no");
		}
		else {
			System.out.println(ans);
		}
	
		br.close();
	}
}
