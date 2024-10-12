import java.util.ArrayDeque;
import java.util.HashMap;

public class quest10 {
    private static int solution(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여 2번 나오도록 만들어줌
        int answer = 0;

        A: for(int i=0; i<n; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int j=i; j<i+n; j++){
                char c = s.charAt(j);
                if(!map.containsKey(c))
                    stack.push(c);
                else{
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "[)(]";
        System.out.println(solution(s));
    }
}
