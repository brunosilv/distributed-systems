package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DigLibSessionRI extends Remote {
    public Book[] search(String a, String b) throws RemoteException;
}
