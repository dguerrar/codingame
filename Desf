import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Desf {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        in.nextLine();
        String LAT = in.next();
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();
        List<DesfibrilatorDTO> dtos= new ArrayList<DesfibrilatorDTO>();
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            System.err.println( DEFIB);
            String[] array= DEFIB.split(";");
            DesfibrilatorDTO dt= new DesfibrilatorDTO(array[0],array[1],array[2],array[3],array[4].replace(',','.'),array[5].replace(',','.'));
            dtos.add(dt);
            //dt.print();
            
        }
        double distance=99999999999f;
        DesfibrilatorDTO min=null;
        DesfibrilatorDTO aux= new DesfibrilatorDTO("-","-","-","-",String.valueOf(LON).replace(',','.'),String.valueOf(LAT).replace(',','.'));
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for(Iterator it= dtos.iterator(); it.hasNext();){
            DesfibrilatorDTO doo=(DesfibrilatorDTO)it.next();
            if (null==min){
                min=doo;
                distance= aux.distance(doo);
            }else{
                double dist= aux.distance(doo);
                System.err.println("distance found:" + dist +"/ name:"+doo.name);
                if (dist<distance){
                    min=doo;
                    distance=dist;
                    System.err.println("distance assigned found:" + dist +"/ name:"+doo.name);
                }
            }
            
        }

        

        System.out.println(min.name);
    }
}

class DesfibrilatorDTO{
    
    String id;
    String name;
    String address;
    String phone;
    String longi;
    String lati;
    
    public DesfibrilatorDTO(String id, String  name,String  address,String  phone,String  longi,String  lati){
        this.id=id;
        this.name= name;
        this.address= address;
        this.phone= phone;
        this.longi= longi;
        this.lati=lati;
        
    }
    
    public double distance(DesfibrilatorDTO other){
        double add=(Double.valueOf(other.lati)+Double.valueOf(this.lati));
        double x=(Double.valueOf(other.longi)-Double.valueOf(this.longi)) * Math.cos(add/2f);
        
        double y=(Double.valueOf(other.lati)-Double.valueOf(this.lati));
        
        double d= Math.hypot(x,y) * 6371f;
        return d;
        
    }
    
    void print(){
        StringBuilder builder= new StringBuilder(); 
        builder.append("id:" + id);
        builder.append("/name:" + name);
        builder.append("/address:" + address);
        builder.append("/phone:" + phone);
        builder.append("/longi:" + longi);
        builder.append("/lati:" + lati);
        
        System.err.println(builder.toString());
    }
    
    
}
