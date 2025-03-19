import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> arr = new ArrayList<>(Collections.nCopies(3, 0));
        while(true){
            st = new StringTokenizer(br.readLine());
            arr.set(0, Integer.parseInt(st.nextToken()));
            arr.set(1, Integer.parseInt(st.nextToken()));
            arr.set(2, Integer.parseInt(st.nextToken()));
            if(arr.get(0) == 0) break;

            Collections.sort(arr);
            if(Math.pow(arr.get(2), 2) == Math.pow(arr.get(0), 2) + Math.pow(arr.get(1), 2)) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}