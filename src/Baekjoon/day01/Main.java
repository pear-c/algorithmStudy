package Baekjoon.day01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A: while(N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();

            for(int i=0; i<input.length(); i++) {
                char c = input.charAt(i);

                try {
                    if(c == '(') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                } catch (Exception e) {
                    System.out.println("NO");
                    continue A;
                }
            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
