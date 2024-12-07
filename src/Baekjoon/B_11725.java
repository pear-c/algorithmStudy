package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 노드
class Node {
    private int val;
    private ArrayList<Node> children;  // 자식노드 -> ArrayList에 저장

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public int getVal() {
        return val;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    // 자식노드 ArrayList에 저장
    public void addChild(Node child) {
        children.add(child);
    }
}

// 트리
class Tree {
    private Node[] nodes;   // 노드 정보 기록
    private int[] parent; // 부모 노드 정보 기록

    // 트리 생성 (1 ~ N)
    public Tree(int size) {
        nodes = new Node[size + 1]; // 1 ~ N 까지
        parent = new int[size + 1]; // 각 노드 부모 저장
        for (int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
            parent[i] = -1; // 부모 초기화
        }
    }

    // 입력 노드 2개 양방향 트리(그래프)로 추가
    public void add(int parentVal, int childVal) {
        nodes[parentVal].addChild(nodes[childVal]);
        nodes[childVal].addChild(nodes[parentVal]);
    }

    // 부모 찾기 DFS 탐색
    public void dfs(int nodeVal) {
        for (Node child : nodes[nodeVal].getChildren()) {
            if (parent[child.getVal()] == -1) { // 부모 없으면
                parent[child.getVal()] = nodeVal; // 현재 노드를 부모로
                dfs(child.getVal()); // 연관된 노드 dfs 탐색
            }
        }
    }

    // 부모 값 반환
    public int getParent(int nodeVal) {
        return parent[nodeVal];
    }
}

// [백준_11725] 트리의 부모 찾기
public class B_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree(N);

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentVal = Integer.parseInt(st.nextToken());
            int childVal = Integer.parseInt(st.nextToken());
            tree.add(parentVal, childVal);
        }

        // root 부터 부모 탐색
        tree.dfs(1);

        for(int i=2; i<=N; i++) {
            System.out.println(tree.getParent(i));
        }
    }
}
