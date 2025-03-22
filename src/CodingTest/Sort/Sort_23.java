package CodingTest.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 정렬 Q.23 : 백준 10825 - 국영수
public class Sort_23 {
    static int N;
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0; i<N; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            students.add(new Student(name, korean, english, math));
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean == o2.korean && o1.english == o2.english && o1.math == o2.math) {
                    return o1.name.compareTo(o2.name);
                } else if(o1.korean == o2.korean && o1.english == o2.english) {
                    return Integer.compare(o2.math, o1.math);
                } else if(o1.korean == o2.korean) {
                    return Integer.compare(o1.english, o2.english);
                } else {
                    return Integer.compare(o2.korean, o1.korean);
                }
            }
        });

        for(Student student : students) {
            System.out.println(student.name);
        }
    }

    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

}
