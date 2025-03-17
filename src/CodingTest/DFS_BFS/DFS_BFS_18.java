package CodingTest.DFS_BFS;

import java.util.Stack;

// DFS/BFS Q.18 - 괄호 변환
public class DFS_BFS_18 {
    static String solution(String p) {
        if(p.isEmpty()) return p;

        int index = splitBalancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if(checkCorrectString(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(solution(v)).append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    static int splitBalancedIndex(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                return i;
            }
        }
        return -1;
    }

    static boolean checkCorrectString(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c == '(' ? ")" : "(");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("()))((()"	));
    }
}
