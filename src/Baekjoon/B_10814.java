package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_10814 {
    static class Member implements Comparable<Member>{
        int id;
        int age;
        String name;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if(this.age == o.age) {
                return this.id - o.id;
            }
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Member> members = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            members.add(new Member(i, sc.nextInt(), sc.next()));
        }

        Collections.sort(members);

        for(int i=0; i<N; i++){
            System.out.println(members.get(i).age + " " + members.get(i).name);
        }
    }
}
