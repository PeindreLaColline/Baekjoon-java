import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = 1;
        long s = scanner.nextLong();

        if(s == 2){
            System.out.println(1);
        }
        else{
            long i = 0;
            while(true){
                if(i>=s) {
                    n--;
                    break;
                }
                i++;
                n++;
                s-=i;
            }
            System.out.println(n);
        }
    }
}