import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans =-1;
        if(n==4){
            ans = -1;
        }
        else if(n==3){
            ans = 1;
        }
        else{
            if(n%5 == 0){
                ans = n/5;
            }
            else{
                for(int i =1; i<=4; i++){
                    if(n<3*i) break;
                    if((n-3*i)%5 == 0){
                        ans = (n-3*i)/5 + i;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}