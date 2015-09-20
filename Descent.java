import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Descent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int MAX_HEIGHT=8;

        // game loop
        while (true) {
            int maxPos=-1;
            String out="HOLD";
            int[] array= new int[8];
            int spaceX = in.nextInt();
            int spaceY = in.nextInt();
            for (int i = 0; i < MAX_HEIGHT; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
                array[i]= mountainH;
                
            }
            //look for the hight
            for (int i = 0; i < MAX_HEIGHT; i++) {
                if (maxPos<array[i]){
                    maxPos=array[i];
                    if (i==spaceX){
                        out="FIRE";
                    }else{
                        out="HOLD";
                    }
                    
                }
            }

            
            

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(out); // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
        }
    }
}
