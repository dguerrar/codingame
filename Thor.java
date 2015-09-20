import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Thor {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        int actualX=initialTX;
        int actualY=initialTY;
        // game loop
        while (true) {
            int remainingTurns = in.nextInt();
        System.err.println(" initialTX:"+ initialTX+"/initialTY:"+initialTY);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int posX=(actualX - lightX);
            int posY=(actualY - lightY);
            
            String out="N";
            if (posX>0 && posY>0){
                out="NW";
                actualX-=1;
                actualY-=1;
            }else if (posX>0 && posY<0){
                out="SW";
                actualX-=1;
                actualY+=1;
            }else if (posX<0 && posY>0){
                actualX+=1;
                actualY-=1;    
                out="NE";
            }else if (posX<0 && posY<0){
                actualX+=1;
                actualY+=1;    
                
                out="SE";
            }
            
            //con ==0
            else if (posX==0 && posY>0){
                actualX+=0;
                actualY-=1;    
                
                out="N";
            }else if (posX==0 && posY<0){
                actualX+=0;
                actualY+=1;            
                
                out="S";
            }else if (posX>0 && posY==0){
                actualX-=1;
                actualY+=0;        
                
                out="W";
            }else if (posX<0 && posY==0){
                actualX+=1;
                actualY+=0;        
                
                out="E";
            }
            
     
            
            System.err.println("actualX:"+ actualX+"/actualY:"+actualY);
            System.err.println("posX:" +  posX + " / posY:" + posY + "/ out:" + out);

            System.out.println(out); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}
