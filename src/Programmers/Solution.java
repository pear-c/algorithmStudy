package Programmers;

import java.util.*;

public class Solution {

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : priorities) {
            pq.offer(num);
        }

        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;
                    if(i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = new int[] {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }
}
