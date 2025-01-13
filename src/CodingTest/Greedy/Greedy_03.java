package CodingTest.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy_03 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int zeroCount = 0;
        int oneCount = 0;

        int flag = input.charAt(0) - '0';
        if(flag == 0) zeroCount++;
        else oneCount++;

        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) != flag){
                oneCount++;

            }
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }
}
