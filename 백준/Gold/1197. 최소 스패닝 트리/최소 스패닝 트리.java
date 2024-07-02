import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class Edge{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
	}
	
	static int v, e;
	static Edge[] edge;
	static int[] parent;
	
	static void make() {
		parent = new int[v+1];
		for(int i =1; i<=v; i++) {
			parent[i] =i;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if(ar==br) return false;
		parent[br] = ar;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v=sc.nextInt();
		e=sc.nextInt();
		
		make();
		edge = new Edge[e];
		
		int from, to, weight;
		for(int i =0; i<e; i++) {
			 from = sc.nextInt();
	         to = sc.nextInt();
	         weight = sc.nextInt();
	         edge[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edge, Comparator.comparingInt(ed -> ed.weight));
		
		int sum = 0, cnt=0;
		for(Edge e:edge) {
			if(union(e.from, e.to)) {
				sum+=e.weight;
				if(++cnt ==v-1) break;
			}
		}
		
		System.out.println(sum);
		sc.close();
	}
}