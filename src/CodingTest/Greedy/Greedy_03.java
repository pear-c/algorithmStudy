package CodingTest.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy_03 {
    public static void main(String[] args) throws Exception {
        // 1. 전체 문자열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 2. 0, 1 이 연속되는 부분 나눔
        int zeroCount = 0;
        int oneCount = 0;

        if(input.charAt(0) == '0')
            zeroCount++;
        else
            oneCount++;

        for(int i=0; i<input.length()-1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '1')
                    zeroCount++;
                else
                    oneCount++;
            }
        }

        // 3. 두 부분 중 더 작은 부분의 개수 출력
        System.out.println(Math.min(zeroCount, oneCount));
    }
}
