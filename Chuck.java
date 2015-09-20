import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Chuck {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        
        //converting string to char in order to get byte
        char[] array= MESSAGE.toCharArray();
        
        //create a big message with the conversion in binary
        StringBuilder newMessage= new StringBuilder();
        for(int i=0; i<array.length;i++){
            int chValue=(int)array[i];
             //convert char to binary
             String binary=Integer.toBinaryString(chValue);
             if (binary.length()<7)
             {
                 binary=String.format("%0"+ (7 - binary.length() )+"d%s",0 ,binary);
                 
             }
             newMessage.append(binary);
        }
        
        //convert to 0..00
        char[] arrayBinary=newMessage.toString().toCharArray();
        
        StringBuilder builder= new StringBuilder();
        char lastCharacter='9';
        for(int j=0; j<arrayBinary.length; j++){
            char aux=arrayBinary[j];
            //last character equals to actual char
            if (lastCharacter!=aux){
                if (j!=0){
                     builder.append(" ");
                }
                
                if (aux=='1'){
                     builder.append("0 ");
                     builder.append("0");
                }else{
                     builder.append("00 ");
                     builder.append("0");
                }
            }else{
                builder.append("0");        
            }
                lastCharacter=aux;
        }


        

        System.out.println(builder.toString());
    }
}
