import java.io.*;

public class Main{
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        if((n/3)%2 == 1){
            if(n%3 == 0){
                System.out.println("SK");
            }
            else if(n%3 == 1){
                System.out.println("CY");
            }
            else if(n%3 == 2){
                System.out.println("SK");
            }
        }
        else{
            if(n%3 == 0){
                System.out.println("CY");
            }
            else if(n%3 == 1){
                System.out.println("SK");
            }
            else if(n%3 == 2){
                System.out.println("CY");
            }
        }
    }
}