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
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject {
    public static final String MESSAGE = "Hello worlds";

    public Server() throws RemoteException {
        super(0);    // required to avoid the 'mic' step, see below
    }

    /*public String getHelloMessage() {
        return MESSAGE;
    }*/

    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        }
        catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        //Instantiate RmiServer
        RMIImpl rmi = new RMIImpl();

        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//localhost/RmiServer", rmi);
        System.out.println("PeerServer bound in registry");
    }
}
