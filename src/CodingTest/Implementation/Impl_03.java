package CodingTest.Implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// [연습문제 - 구현] Q.09 - 문자열 압축
public class Impl_03 {
    static int solution(String s) {
        int len = s.length();
        int min = len;

        for(int i=1; i<=len / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prevText = s.substring(0, i);
            int count = 1;

            for(int j=i; j<=len; j+=i) {
                String splitText = s.substring(j, Math.min(j+i, len));
                if(splitText.equals(prevText)) {
                    count++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    count = 1;
                    sb.append(prevText);
                    prevText = splitText;
                }
            }
            sb.append(prevText);
            min = Math.min(min, sb.length());
        }
        return min;
    }
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));

    }

}
