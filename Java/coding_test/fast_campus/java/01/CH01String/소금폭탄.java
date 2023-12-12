import java.util.*;

public class 소금폭탄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] curTimeS = sc.nextLine().split(":");
        String[] robotTimeS = sc.nextLine().split(":");
        
        int[] curTime = new int[3];
        int[] robotTime = new int[3];
        int outputSec = 0;
        int outputMin = 0;
        int outputHour = 0;
        
        for(int i = 0; i < 3; i++) {
            curTime[i] = Integer.parseInt(curTimeS[i]);
            robotTime[i] = Integer.parseInt(robotTimeS[i]);
        }
        
        outputSec += robotTime[2] - curTime[2];
        
        if(outputSec < 0) {
            outputSec += 60;
            outputMin -= 1;
        }
        
        outputMin += robotTime[1] - curTime[1];
        
        if(outputMin < 0) {
            outputMin += 60;
            outputHour -= 1;
        }
        outputHour += robotTime[0] - curTime[0];
        if(outputHour < 0) {
            outputHour += 24;
        }
        if(outputHour == 0 &&  outputMin == 0 && outputSec == 0) {
            System.out.println("24:00:00");
        } else {
            printTime(outputHour);
            System.out.print(":");
            printTime(outputMin);
            System.out.print(":");
            printTime(outputSec);
        }

    }
    
    
    public static void printTime(int time) {
        if(time < 10) {
            System.out.print("0");
        }
        System.out.print(time);
    }
}
