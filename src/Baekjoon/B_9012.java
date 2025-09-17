package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A : while (N-- > 0) {
            Stack<Integer> stack = new Stack<>();
            String line = br.readLine();

            for(int i=0; i<line.length(); i++){
                char ch = line.charAt(i);
                if(ch == '(') {
                    stack.push(i);
                } else {
                    if(stack.isEmpty()){
                        System.out.println("NO");
                        continue A;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
