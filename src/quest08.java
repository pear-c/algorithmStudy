import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class quest08 {
    private static boolean solution(String s){
        // 맨 앞이 ')'거나 / 맨 뒤가 '('가 오면 안됨
        if(s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(')
            return false;

        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else
                count--;

            if(count < 0)
                return false;
        }
        return count == 0;
    }
    private static boolean solution2(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for(char c : a){
            if(c == '(')
                stack.push(c);
            else{
                if(stack.isEmpty() || stack.pop() == c)
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution2(s));
    }
}
