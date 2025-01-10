package CodingTest.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = input.charAt(0) - '0';
        for(int i=0; i<input.length()-1; i++){
            int n = input.charAt(i) - '0';
            if(n == 0)
                result += input.charAt(i+1) - '0';
            else
                result *= input.charAt(i+1) - '0';
        }
        System.out.println(result);
    }
}
