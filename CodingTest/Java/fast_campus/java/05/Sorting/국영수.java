import java.util.*;
import java.io.*;

public class 국영수 {
    
    static class Student implements Comparable<Student> {
        public String name;
        public int korean, math, english;
        
        @Override
        public int compareTo(Student other) {
            if(korean != other.korean) {
                return other.korean - korean;
            }
            if(english != other.english) {
                return english - other.english;
            }
            if(math != other.math) {
                return other.math - math;
            }
            return name.compareTo(other.name);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        Student[] list = new Student[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student newStudent = new Student();
            newStudent.name = name;
            newStudent.english = english;
            newStudent.korean = korean;
            newStudent.math = math;
            list[i] = newStudent;
        }
        
        Arrays.sort(list);
        
        for(int i = 0; i < N; i++) {
            bw.write(list[i].name + "\n");
        }
        
        bw.flush();
    }
}
