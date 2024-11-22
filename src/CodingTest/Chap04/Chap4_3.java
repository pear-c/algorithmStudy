package CodingTest.Chap04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chap4_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int col = s.charAt(0) - 'a' + 1;
        int row = s.charAt(1) - '0';

        int[][] steps = {
                {-2, -1}, {-2, 1},
                {-1, 2}, {1, 2},
                {2, -1}, {2, 1},
                {-1, -2}, {1, -2}
        };

        int count = 0;
        for(int[] step : steps) {
            int nx = col + step[0];
            int ny = row + step[1];
            if(nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8)
                count++;
        }

        System.out.println(count);
    }
}
