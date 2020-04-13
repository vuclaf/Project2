import java.util.*;
import java.io.*;
import java.text.*;
/**
 * Main class to read input into the CoffeeShop simulator
 * Author Evan Vu
 */
public class Main
{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        int cusNum=0;
        float p1 = sc.nextFloat();
        float p2 = sc.nextFloat();
        float cost = sc.nextFloat();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        CoffeeShop shop = new CoffeeShop(1,t1,t2,cost,p1,p2);
        while (sc.hasNext()){
            cusNum++;
            String newTime = sc.next();
            /*String[] time = newTime.split(":");
            
                int hour = Integer.parseInt(time[0]);
                int mins = Integer.parseInt(time[1]);
                int secs = Integer.parseInt(time[2]);
                int eventTime = hour*3600 + mins*60 + secs;
            */
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            Date date = sdf.parse(newTime);
            int eventTime = (int) date.getTime()/1000 - 18000;
            shop.addArrival(cusNum, eventTime);
        }
        shop.runSim();
    }
}
