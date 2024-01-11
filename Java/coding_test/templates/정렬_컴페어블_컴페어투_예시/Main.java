package Java.coding_test.templates.정렬_컴페어블_컴페어투_예시;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Student[] sArr;
    static class Student implements Comparable<Student> {
        int age;
        String name;

        Student(int age, String name) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            return age - o.age;
        }

        public String printAgeAndName() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(
            st.nextToken()
        );
        sArr = new Student[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            sArr[i] = new Student(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(sArr);

        for(int i = 0; i < N; i++) {
            bw.write(sArr[i].printAgeAndName() + '\n');
        }

        bw.flush();
    }

}
