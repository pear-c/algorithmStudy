package Baekjoon.LinkedList;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_23309 {
    static int N, M;
    static Map<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int headInt = Integer.parseInt(st.nextToken());
        Node head = new Node(headInt);
        map.put(headInt, head);

        Node cur = head;
        for(int i=1; i<N; i++) {
            int curInt = Integer.parseInt(st.nextToken());
            Node next = new Node(curInt);
            cur.next = next;
            next.prev = cur;
            map.put(curInt, next);
            cur = next;
        }
        cur.next = head;
        head.prev = cur;

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int i = Integer.parseInt(st.nextToken());
            if(command.equals("BN")) {
                int j = Integer.parseInt(st.nextToken());

                Node newNode = new Node(j);
                Node curNode = map.get(i);
                Node nextNode = curNode.next;

                sb.append(nextNode.value).append("\n");

                newNode.next = nextNode;
                nextNode.prev = newNode;

                curNode.next = newNode;
                newNode.prev = curNode;

                map.put(j, newNode);
            } else if(command.equals("BP")) {
                int j = Integer.parseInt(st.nextToken());

                Node newNode = new Node(j);
                Node curNode = map.get(i);
                Node prevNode = curNode.prev;

                sb.append(prevNode.value).append("\n");

                prevNode.next = newNode;
                newNode.prev = prevNode;

                newNode.next = curNode;
                curNode.prev = newNode;

                map.put(j, newNode);
            } else if(command.equals("CP")) {
                Node curNode = map.get(i);
                Node prevNode = curNode.prev;

                sb.append(prevNode.value).append("\n");

                prevNode.prev.next = curNode;
                curNode.prev = prevNode.prev;

                map.remove(prevNode.value);
            } else if(command.equals("CN")) {
                Node curNode = map.get(i);
                Node nextNode = curNode.next;

                sb.append(nextNode.value).append("\n");

                curNode.next = nextNode.next;
                nextNode.next.prev = curNode;

                map.remove(nextNode.value);
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
