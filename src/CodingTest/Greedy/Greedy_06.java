package CodingTest.Greedy;

import java.util.*;

public class Greedy_06 {
    static class Food {
        int time;
        int idx;

        public Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }
    static int solution(int[] food_times, int k) {
        PriorityQueue<Food> pq = new PriorityQueue<>(Comparator.comparingInt(f -> f.time));
        for(int i=0; i<food_times.length; i++) {
            pq.offer(new Food(food_times[i], i+1));
        }

        long totalTime = 0;
        long prevTime = 0;
        long remainingFoods = food_times.length;

        while(!pq.isEmpty()) {
            long currentTime = pq.peek().time;
            long timeToConsume = (currentTime - prevTime) * remainingFoods;

            if(totalTime + timeToConsume > k) {
                long remainingTime = k - totalTime;
                List<Food> remaining = new ArrayList<>(pq);

                remaining.sort(Comparator.comparingInt(f -> f.idx));
                return remaining.get((int) (remainingTime % remainingFoods)).idx;
            }

            totalTime += timeToConsume;
            prevTime = currentTime;
            remainingFoods--;
            pq.poll();
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        int[] food_times = {3,1,2};
        int k = 5;
        System.out.println(solution(food_times, k));
    }
}
