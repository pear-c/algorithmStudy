package Ebook;

import java.util.Stack;

public class quest09 {
    private static String solution(int n){
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            sb.append(n%2);
            n/=2;
        }
        return sb.reverse().toString();
    }
    private static String solution2(int n){
        Stack<Integer> st = new Stack<>();
        while(n > 0){
            int remainder = n % 2;
            st.push(remainder);
            n/=2;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(12345));
    }
}
