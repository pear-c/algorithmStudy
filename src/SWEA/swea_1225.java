package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc <= 10; tc++) {
            StringBuilder sb = new StringBuilder();
            int test = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < 8; i++) {
                q.add(sc.nextInt());
            }

            A:while(true) {
                for(int i=1; i<=5; i++) {
                    int n = q.poll() - i;
                    if(n <= 0) {
                        n = 0;
                        q.add(n);
                        break A;
                    }
                    q.add(n);
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i=0; i<8; i++) {
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
            System.out.println(sb);
        }
    }
}
