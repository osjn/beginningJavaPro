package rmiexample;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {
    public RMIServer() throws RemoteException {
        super();
    }

    public int addTwoNumbers(int a, int b) throws RemoteException {
        System.out.println("addTwoNumbers was called");
        return a + b;
    }

    public int substractTwoNumbers(int a, int b) throws RemoteException {
        System.out.println("substractTwoNumbers was called");
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server...");
        try {
            // create registry on local machine running on port 1099
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry was created");
        } catch (RemoteException e) {
            System.out.println("RemoteException occurred: ");
            e.printStackTrace();
        }

        RMIServer theServer = new RMIServer();

        // bind the server instance to the name "RMIServer"
        Naming.rebind("//localhost/RMIServer", theServer);
        System.out.println("RMIServer bound in registry");
    }
}
