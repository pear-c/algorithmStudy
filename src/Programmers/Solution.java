package Programmers;


import java.util.PriorityQueue;

public class Solution {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int count = 0;

    private static void makeSpicy(PriorityQueue<Integer> pq) {
        int a = pq.poll();
        int b = pq.poll();

        pq.add(a + (b*2));
    }

    public static int solution(int[] scoville, int K) {
        for(int spice : scoville) {
            pq.offer(spice);
        }

        while(pq.size() > 1 && pq.peek() <= K){
            makeSpicy(pq);
            count++;
        }

        if(count == 0 || pq.peek() <= K) {
            return -1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }
}
