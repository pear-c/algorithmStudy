package Baekjoon.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class B_1406 {
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> temp = new Stack<>();
    static int M;
    static int cursor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String input = br.readLine();
        for(int i=0; i<input.length(); i++) {
            stack.push(input.charAt(i));
        }
        cursor = stack.size();


        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            String[] inputs = br.readLine().split(" ");

            char command = inputs[0].charAt(0);
            if(command == 'L') {
                if(!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
            } else if(command == 'D') {
                if(!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            } else if(command == 'B') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(command == 'P') {
                char c = inputs[1].charAt(0);
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!temp.isEmpty()) {
            sb.append(temp.pop());
        }
        System.out.println(sb);
    }
}
