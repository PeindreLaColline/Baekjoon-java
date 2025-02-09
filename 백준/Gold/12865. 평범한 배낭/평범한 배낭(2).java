import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N+1][2];

        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for(int i =1; i<=N; i++){
            for(int w = 0; w<=K; w++) {
                if (items[i][0] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - items[i][0]] + items[i][1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
