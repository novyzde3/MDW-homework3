/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdw.hw3;

/**
 *
 * @author New
 */
import java.rmi.Naming;

public class Client {
    public static void main(String args[]) throws Exception {
        RMIIntf obj = (RMIIntf) Naming.lookup("//localhost/RmiServer");
        System.out.println(obj.getHelloMessage());

        double cash, amount = 1000;
        //Meny from = Meny.GBP;
        //Meny to = Meny.USD;

        for (Meny from : Meny.values()) {
            for (Meny to : Meny.values()) {
                if (from != to) {
                    cash = obj.convert(from, to, amount);
                    System.out.println("Vymena z " + from + " na " + to + " castka " + amount + ": " + cash);
                }
            }
        }

        

        
    }
}
