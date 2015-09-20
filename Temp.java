import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Temp.java {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String TEMPS = in.nextLine(); // the N temperatures expressed as integers ranging from -273 to 5526
        int result=5527;
        
        
        StringTokenizer tokens= new StringTokenizer(TEMPS," ");
        if (tokens.countTokens()==0){
            result=0;
        }else{
        
            while(tokens.hasMoreTokens()){
                String valor=tokens.nextToken();
                
                 int actualNumber=Integer.valueOf(valor).intValue();
                    if (Math.abs(actualNumber)<Math.abs(result)){
                        result=actualNumber;
                    }else if (Math.abs(actualNumber)==Math.abs(result) && actualNumber> result){
                        result=actualNumber;
                    }
                
                
            }
        }
        

        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
}
