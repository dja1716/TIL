import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static char[] command;
    static int curX = 0;
    static int curY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = '.';
            }
        }

        st = new StringTokenizer(bf.readLine());
        if (st.hasMoreTokens()) { // Check if there is a token to read
            command = st.nextToken().toCharArray();
            
            for(int i = 0; i < command.length; i++) {
                process(i);
            }
        }


        for(int i = 0; i < N; i++) {
            bw.write(new String(map[i]) + '\n');
        }
        bw.flush();
    }

    public static void process(int commandI) {
        if(command[commandI] == 'D') {
            if(curY + 1 >= N) return;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '-') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '|';
                }
            }
            curY += 1;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '-') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '|';
                }
            }
        } else if(command[commandI] == 'U') {
            if(curY - 1 < 0) return;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '-') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '|';
                }
            }
            curY -= 1;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '-') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '|';
                }
            }
        } else if(command[commandI] == 'L') {
            if(curX - 1 < 0) return;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '|') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '-';
                }
            }
            curX -= 1;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '|') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '-';
                }
            }
        } else if(command[commandI] == 'R') {
            if(curX + 1 >= N) return;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '|') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '-';
                }
            }
            curX += 1;
            if(map[curY][curX] != '+') {
                if(map[curY][curX] == '|') {
                    map[curY][curX] = '+';
                } else {
                    map[curY][curX] = '-';
                }
            }
        }
    }
}
