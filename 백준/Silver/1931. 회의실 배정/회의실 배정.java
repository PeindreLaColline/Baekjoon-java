import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     int N = sc.nextInt();
	
	     List<int[]> times = new ArrayList<>();
	    
	     for (int i = 0; i < N; i++) {
	         int s = sc.nextInt();
	         int e = sc.nextInt();
	         times.add(new int[]{s, e});
	     }
	
	     // 정렬하기
	     Collections.sort(times, new Comparator<int[]>() {
	         public int compare(int[] o1, int[] o2) {
	             // 종료 시간 기준으로 오름차순 정렬, 종료 시간이 같으면 시작 시간 기준으로 오름차순 정렬
	        	 // 반례 times = [[4,4],[1,4]]
	             if (o1[1] == o2[1]) {
	                 return Integer.compare(o1[0], o2[0]);
	             }
	             return Integer.compare(o1[1], o2[1]);
	         }
	     });
	
	     int answer = 1;
	     int cur_s = times.get(0)[0];
	     int cur_e = times.get(0)[1];
	
	     for (int j = 1; j < N; j++) {
	         int s = times.get(j)[0];
	         int e = times.get(j)[1];
	         if (s >= cur_e) {
	             answer++;
	             cur_s = s;
	             cur_e = e;
	         }
	     }
	
	     System.out.println(answer);
    }
}