package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DigLibFactoryRI extends Remote {
    public DigLibSessionRI login (String username, String password) throws RemoteException;
}