package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class swea_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] prices = new int[N];

            for(int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(input[i]);
            }

            long maxProfit = 0;
            int maxPrice = 0;

            for(int i = N-1; i >= 0; i--) {
                if(prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    maxProfit += maxPrice - prices[i];
                }
            }

            System.out.println("#" + test_case + " " + maxProfit);
        }
    }
}
