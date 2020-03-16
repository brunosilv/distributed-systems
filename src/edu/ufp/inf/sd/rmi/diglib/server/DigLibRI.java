package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DigLibRI extends Remote {
    public String methodName() throws RemoteException;
}