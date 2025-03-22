package CodingTest.Sort;

import java.util.*;

// 정렬 Q.26 : 백준 1715 - 카드 정렬하기
public class Sort_26 {
    static PriorityQueue<Integer> cards = new PriorityQueue<>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i=0; i<N; i++) {
            cards.add(sc.nextInt());
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        while(cards.size() > 1) {
            int a = cards.poll();
            int b = cards.poll();
            int sum = a + b;
            result += sum;
            cards.add(sum);
        }

        System.out.println(result);
    }
}
