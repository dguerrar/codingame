import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Skynet1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int road = in.nextInt(); // the length of the road before the gap.
        int gap = in.nextInt(); // the length of the gap.
        int platform = in.nextInt(); // the length of the landing platform.

        
        // game loop
        while (true) {
            String out="WAIT";
            int speed = in.nextInt(); // the motorbike's speed.
            int coordX = in.nextInt(); // the position on the road of the motorbike.
            System.err.println("road:" + road +"/gap:"+ gap +"/platform:" + platform);
            System.err.println ("ini speed :" +speed+"/coordX:"+ coordX );
            
            //jump
            if (coordX==road-1){
                out="JUMP";
            }else if (coordX<road-1){
                if(speed<=gap){
                    out="SPEED";
                }else if (speed>gap+1){
                    out="SLOW"; 
                }else{
                    out="WAIT";
                }
            }else{
                out="SLOW";
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(out); // A single line containing one of 4 keywords: SPEED, SLOW, JUMP, WAIT.
        }
    }
}
