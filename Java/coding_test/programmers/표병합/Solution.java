import java.util.*;
// 10:28
// 12:19 Score: 72.7
// 12:26 Score: 100


public class Solution {

    static ArrayList<String> answers = new ArrayList<>();
    static String[][] chart = new String[51][51];
    static int[][] mergeChart = new int[51][51];
    static int mergeId = 1;


    public String[] solution(String[] commands) {

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                chart[i][j] = "";
            }
        }

        for(int i = 0; i < commands.length; i++) {
            commandHandler(commands[i]);
        }

        return answers.toArray(new String[answers.size()]);
    }




    public static void commandHandler(String command) {
        String[] commandArr = command.split(" ");


        switch (commandArr[0]) {
            case "UPDATE":
                if(commandArr.length == 4) {
                    update(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]), commandArr[3]);
                } else if(commandArr.length == 3) {
                    update(commandArr[1], commandArr[2]);
                }
                break;
            case "MERGE":
                merge(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]), Integer.parseInt(commandArr[3]), Integer.parseInt(commandArr[4]));
                break;
            case "UNMERGE":
                unmerge(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                break;
            case "PRINT":
                print(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                break;
        }
    }

    public static void merge(int r1, int c1, int r2, int c2) {
        if(r1 == r2 && c1 == c2) return;
        String value = !chart[r1][c1].equals("") ? chart[r1][c1] : chart[r2][c2];
        chart[r2][c2] = value;
        chart[r1][c1] = value;
        if(mergeChart[r1][c1] == 0 && mergeChart[r2][c2] == 0) {
            mergeChart[r1][c1] = mergeId;
            mergeChart[r2][c2] = mergeId;
            mergeId++;
        } else if(mergeChart[r1][c1] > 0 && mergeChart[r2][c2] > 0) {
            int targetId = mergeChart[r1][c1];
            for(int i = 1; i < 51; i++) {
                for(int j = 1; j < 51; j++) {
                    if(mergeChart[i][j] == targetId) {
                        mergeChart[i][j] = mergeChart[r2][c2];
                        
                        chart[i][j] = value;
                    } else if(mergeChart[i][j] == mergeChart[r2][c2]) {
                        chart[i][j] = value;
                    }
                }
            }
        } else if(mergeChart[r1][c1] > 0) {
            for(int i = 1; i < 51; i++) {
                for(int j = 1; j < 51; j++) {
                    if(mergeChart[i][j] == mergeChart[r1][c1]) {
                        chart[i][j] = value;
                    }
                }
            }
            mergeChart[r2][c2] = mergeChart[r1][c1];
        } else if(mergeChart[r2][c2] > 0) {
            for(int i = 1; i < 51; i++) {
                for(int j = 1; j < 51; j++) {
                    if(mergeChart[i][j] == mergeChart[r2][c2]) {
                        chart[i][j] = value;
                    }
                }
            }
            mergeChart[r1][c1] = mergeChart[r2][c2];
        }

    }
    public static void unmerge(int r, int c) {
        if(mergeChart[r][c] == 0) return;
        int targetId = mergeChart[r][c];
        mergeChart[r][c] = 0;

        for(int i = 1; i < 51; i++) {
            for(int j = 1; j < 51; j++) {
                if(mergeChart[i][j] == targetId) {
                    mergeChart[i][j] = 0;
                    chart[i][j] = "";
                }
            }
        }

    }
    public static void update(int r, int c, String value) {
        chart[r][c] = value;

        if(mergeChart[r][c] > 0) {
            for(int i = 1; i < 51; i++) {
                for(int j = 1; j < 51; j++) {
                    if(mergeChart[i][j] == mergeChart[r][c]) {
                        chart[i][j] = value;
                    }
                }
            }
        }
    }
    public static void update(String value1, String value2) {
        for(int i = 1; i < 51; i++) {
            for(int j = 1; j < 51; j++) {
                if(chart[i][j].equals(value1)) {
                    chart[i][j] = value2;
                }
            }
        }
    }
    public static void print(int r, int c) {
        if(!chart[r][c].equals("")) {
            answers.add(chart[r][c]);
        } else {
            answers.add("EMPTY");
        }
    }
}