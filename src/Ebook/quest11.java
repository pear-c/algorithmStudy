package Ebook;

import java.util.Stack;

public class quest11 {
    private static int solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }
            else{
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        String s = "cdcd"; // ->
        System.out.println(solution(s));
    }
}
