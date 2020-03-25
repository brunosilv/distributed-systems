package edu.ufp.inf.sd.rmi.observer.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ObserverRI extends Remote {
    public String methodName() throws RemoteException;
}