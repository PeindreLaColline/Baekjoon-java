import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int a;
    int b;

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair o) {
        return this.b - o.b; //오름차순
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Pair> lines = new ArrayList<>();

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new Pair(a,b));
        }

        lines.sort(Comparator.comparingInt(p -> p.a));

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int ans = 1;
        pq.add(new Pair(lines.get(0).a, lines.get(0).b));
        for(int i = 1; i<n; i++){
            if(!pq.isEmpty() && lines.get(i).a >= pq.peek().b ){
                pq.poll();
            }
            pq.add(new Pair(lines.get(i).a, lines.get(i).b));
            if(pq.size()>ans) ans = pq.size();
        }

        System.out.println(ans);
    }
}