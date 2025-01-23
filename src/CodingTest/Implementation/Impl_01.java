package CodingTest.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Impl_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum_left = 0;
        int sum_right = 0;

        for(int i=0; i<input.length(); i++) {
            if(i < input.length()/2)
                sum_left += input.charAt(i) - '0';
            else
                sum_right += input.charAt(i) - '0';
        }
        System.out.println(sum_left == sum_right ? "LUCKY" : "READY");
    }
}
