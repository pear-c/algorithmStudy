package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(!queue.isEmpty()) {
                        System.out.println(queue.peek());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "back":
                    if(!queue.isEmpty()) {
                        System.out.println(queue.peekLast());
                    } else {
                        System.out.println("-1");
                    }
                    break;
            }
        }
    }
}
