import java.io.*;
import java.util.*;

public class Main {

    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static String text;
    static String key;
    static Map<Character, Pos> board = new HashMap<>();
    static List<char[]> seg = new ArrayList<>();
    static StringBuilder answer = new StringBuilder(); // <- answer
    static char[][] arr = new char[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        text = br.readLine();
        key = br.readLine();

        createBoard();
        createSeg();
        encode();




        bw.write(new String(answer));
        bw.flush();
    }

    static void encodeHelper(char[] cArr) {
        Pos c1 = board.get(cArr[0]);
        Pos c2 = board.get(cArr[1]);

        if(c1.x == c2.x) {
            if(c1.y == 4) {
                answer.append(arr[c1.x][0]);
            } else {
                answer.append(arr[c1.x][c1.y+1]);
            }

            if(c2.y == 4) {
                answer.append(arr[c2.x][0]);
            } else {
                answer.append(arr[c2.x][c2.y+1]);
            }
        } else if(c1.y == c2.y) {
           if(c1.x == 4) {
                answer.append(arr[0][c1.y]);
            } else {
                answer.append(arr[c1.x+1][c1.y]);
            }

            if(c2.x == 4) {
                answer.append(arr[0][c2.y]);
            } else {
                answer.append(arr[c2.x+1][c2.y]);
            } 
        } else {
            answer.append(arr[c1.x][c2.y]);
            answer.append(arr[c2.x][c1.y]);
        }
    }

    static void encode() {
        for(int i = 0; i < seg.size(); i++) {
            encodeHelper(seg.get(i));
        }
    }

    static void createSeg() {
        int idx = 0;
        while(idx < text.length()) {
            char c1 = text.charAt(idx++);
            if(idx == text.length()) {
                char[] temp = {c1, 'X'};
                seg.add(temp);
                break;
            }
            char c2 = text.charAt(idx++);
            

            if(c1 == c2) {
                if(c1 == 'X') {
                    char[] temp = {c1, 'Q'};
                    seg.add(temp);
                } else {
                    char[] temp = {c1, 'X'};
                    seg.add(temp);
                }
                idx--;
            } else {
                char[] temp = {c1, c2};
                seg.add(temp);
            }
        }
    }

    static void createBoard() {
        int x = 0;
        int y = 0;
        for(int i = 0; i < key.length(); i++) {
            if(board.containsKey(key.charAt(i))) {
                continue;
            }
            board.put(key.charAt(i), new Pos(x, y));
            arr[x][y] = key.charAt(i);
            int[] moved = moveXY(x, y);
            x = moved[0];
            y = moved[1];
        }

        for(char c = 'A'; c <= 'Z'; c++) {
            if(board.containsKey(c) || c == 'J') {
                continue;
            }
            board.put(c, new Pos(x, y));
            arr[x][y] = c;
            int[] moved = moveXY(x, y);
            x = moved[0];
            y = moved[1];
            
        }
    }

    static int[] moveXY(int x, int y) {
        y++;
        if(y == 5) {
            y = 0;
            x++;
        }
        int[] result = {x, y};
        return result;
    }
}
