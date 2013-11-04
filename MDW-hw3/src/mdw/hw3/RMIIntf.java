/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdw.hw3;

/**
 *
 * @author New
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface RMIIntf extends Remote {
    public String getHelloMessage() throws RemoteException;
    public double convert(Meny from, Meny to, double amount) throws RemoteException;
}
