package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_14567 {
    static class Node {
        private int num;
        private ArrayList<Node> parents;
        private ArrayList<Node> children;
        private int degree;

        public Node (int num) {
            this.num = num;
            this.parents = new ArrayList<Node>();
            this.children = new ArrayList<Node>();
            this.degree = 0;
        }
        public int getNum() {
            return num;
        }
        public ArrayList<Node> getParents() {
            return parents;
        }
        public ArrayList<Node> getChildren() {
            return children;
        }
        public void addParent(Node parent) {
            parents.add(parent);
        }
        public void addChild(Node child) {
            children.add(child);
        }
        public int getDegree() {
            return degree;
        }
        public void setDegree() {
            this.degree = this.parents.size();
        }
    }

    // 노드 부모, 자식 정보 세팅 함수
    static void setNode(int a, int b, ArrayList<Node> nodes) {
        nodes.get(a).addChild(nodes.get(b));
        nodes.get(b).addParent(nodes.get(a));
        nodes.get(b).setDegree();
    }

    // 위상 정렬 용 진입 차수 업데이트 함수
    static void updateDegree(Node[] nodes) {
        for(int i=1; i<nodes.length; i++) {
            nodes[i].setDegree();
        }
    }

    static void deleteParent(ArrayList<Node> nodes, Node cur) {
        for(int i=0; i<nodes.size(); i++) {
            nodes.get(i).getParents().remove(cur);
            nodes.get(i).setDegree();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        // 진입차수 배열 생성
        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i=1; i<=N; i++) {
            nodes.add(new Node(i));
        }

        // 초기 선수과목 입력
        while(M-- > 0) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            setNode(a-1, b-1, nodes);
        }

        int time = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(nodes.get(0));

        while(nodes.size() > 0) {
            if(!q.isEmpty()) {

            }
            Node cur = q.poll();
            System.out.println(cur.getNum());
            nodes.remove(cur);
            deleteParent(cur.getChildren(), cur);    // 부모 정보 삭제

            nodes.sort(Comparator.comparingInt(Node::getDegree));

            for(Node node : nodes) {
                if(node.getDegree() == 0 && !q.contains(node)) {
                    q.add(node);
                }
            }
        }
    }
}
