import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int w;
    int v;

    public Pair(int w, int v){
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Pair o) {
        return this.w - o.w;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Pair> items = new ArrayList<>(n+1);

        int w, v;
        items.add(new Pair(0,0));
        for(int i =1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            items.add(new Pair(w,v));
        }

        int[][] dp = new int[n+1][k+1];

        for(int i =1; i<=n; i++){
            for(int j =1; j<=k; j++){
                if(items.get(i).w <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items.get(i).w] + items.get(i).v);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);

    }
}
