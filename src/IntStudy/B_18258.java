package IntStudy;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// [백준_18258] 큐 2
public class B_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 저장할 큐
        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) { // N번 만큼 반복
            // 커맨드 입력
            String command = br.readLine();

            // #1. push (기존의 StringTokenizer 방법에서 변경)
            if(command.contains("push")){ // contains 내부 로직(String 전체 선회)
                int num = Integer.parseInt(command.split(" ")[1]);
                q.add(num);
            }
            else {
                switch (command) {
                    // # if문으로 처음에
                    // #2. pop
                    case "pop":
                        sb.append(q.isEmpty() ? "-1" : q.poll()).append("\n");
                        break;

                    // #3. size
                    case "size":
                        sb.append(q.size()).append("\n");
                        break;

                    // #4. empty
                    case "empty":
                        sb.append(q.isEmpty() ? "1\n" : "0\n");
                        break;

                    // #5. front
                    case "front":
                        sb.append(q.isEmpty() ? "-1" : q.peek()).append("\n");
                        break;

                    // #6. back
                    case "back":
                        sb.append(q.isEmpty() ? "-1" : q.getLast()).append("\n");
                        break;
                }
            }
        }
        System.out.println(sb);
    }
}
