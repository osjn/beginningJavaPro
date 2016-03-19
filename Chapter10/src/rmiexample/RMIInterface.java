package rmiexample;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    public int addTwoNumbers(int a, int b) throws RemoteException;
    public int substractTwoNumbers(int a, int b) throws RemoteException;
}
