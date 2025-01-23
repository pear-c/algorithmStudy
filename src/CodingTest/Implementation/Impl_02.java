package CodingTest.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Impl_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        int result = 0;
        for(int i=0; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                sb.append(input.charAt(i));
            } else {
                result += input.charAt(i) - '0';
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);

        System.out.println(s + result);
    }
}
