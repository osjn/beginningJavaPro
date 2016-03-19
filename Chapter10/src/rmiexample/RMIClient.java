package rmiexample;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        // get RMI registry running at the local computer
        Registry registry = LocateRegistry.getRegistry("localhost");
        // request interface bound on name "RMIServer"
        RMIInterface serverInterface = (RMIInterface) registry.lookup("RMIServer");

        // execute methods over RMI
        System.out.println(serverInterface.addTwoNumbers(3, 4));
        System.out.println(serverInterface.substractTwoNumbers(10, 3));
    }
}
