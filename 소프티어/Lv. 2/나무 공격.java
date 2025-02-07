import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[l];

        int tmp;
        for(int i =0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<r; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    arr[i]++;   
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());

        int[] attack = new int[l];

        for(int i =s1-1; i<e1; i++){
            attack[i]++;
        }

        for(int i =s2-1; i<e2; i++){
            attack[i]++;
        }

        int ans =0;
        for(int i =0; i<l; i++){
            if(arr[i]-attack[i] > 0){
                ans += arr[i]-attack[i];
            }
        }

        System.out.println(ans);

        
    }
}
