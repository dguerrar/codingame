import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Paranoid {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        int[] elevators= new int[nbFloors];
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevators[elevatorFloor]=elevatorPos;
        }
        //setting the pos for the exit
        elevators[exitFloor]=exitPos;
        // game loop
        int loop=0;
        while (true) {
            
            
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            //all clones in block state
            if (-1==cloneFloor && -1==clonePos && direction.equals("NONE")) {
                System.out.println("WAIT");
            }else{
                //clone trying to get out of the world
                System.err.print("/ pos ele:" +elevators[cloneFloor]);
                if ((clonePos==0) || (clonePos==width -1) || (stopAfterExit(elevators[cloneFloor],clonePos, direction))){
                        System.out.println("BLOCK");

                }else{
                    System.out.println("WAIT");
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

           //loop= (loop == 3 ? 0: loop+1);
        }
    }
    
    
    public static boolean stopAfterExit(int positionExit, int positionClone, String directions){
        boolean ret=false;
        
        if (directions.equalsIgnoreCase("LEFT") && positionClone<positionExit){
            ret=true;
        }else if (directions.equalsIgnoreCase("RIGHT") && positionClone>positionExit){
            ret=true;
        }
        return ret;
    }
    
}
