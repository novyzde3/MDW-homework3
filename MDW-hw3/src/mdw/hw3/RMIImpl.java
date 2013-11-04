/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdw.hw3;

/**
 *
 * @author New
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
 
public class RMIImpl extends UnicastRemoteObject implements RMIIntf {
    private final double EUR2USD = 1.3514;
    private final double EUR2GBP = 0.8462;
    private final double GBP2EUR = 1.1812;
    private final double GBP2USD = 1.5967;
    private final double USD2EUR = 0.7400;
    private final double USD2GBP = 0.6263;
    
    
    
    public RMIImpl() throws RemoteException {
    }
 
    @Override
    public String getHelloMessage() throws RemoteException {
        return "Hello Worlde!";
    }

    @Override
    public double convert(Meny from, Meny to, double amount) throws RemoteException {
        if (from == Meny.EUR) {
            if (to == Meny.GBP) {
                return EUR2GBP * amount;
            }
            else if (to == Meny.USD) {
                return EUR2USD * amount;
            }
        }
         
        else if (from == Meny.GBP) {
            if (to == Meny.EUR) {
                return GBP2EUR * amount;
            }
            else if (to == Meny.USD) {
                return GBP2USD * amount;
            }
        }
        
        else if (from == Meny.USD) {
            if (to == Meny.EUR) {
                return USD2EUR * amount;
            }
            else if (to == Meny.GBP) {
                return USD2GBP * amount;
            }
        }
        
        return 0.;
    }
}
