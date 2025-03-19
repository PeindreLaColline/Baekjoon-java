import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ans = 0;
        long m = 1234567891;
        long r = 1;
        for(int i =0; i<s.length(); i++){
            ans += ((s.charAt(i)-'a'+1)*r)%m;
            ans %= m;
            r = (r * 31)%m;
        }
        System.out.println(ans);
    }
}