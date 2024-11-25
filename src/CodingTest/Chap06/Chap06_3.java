package CodingTest.Chap06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chap06_3 {
    static class Student {
        String name;
        int score;
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            students.add(new Student(s[0], Integer.parseInt(s[1])));
        }

        students.sort(Comparator.comparingInt(student -> student.score));

        for(Student student : students) {
            System.out.print(student.name + " ");
        }
    }
}
