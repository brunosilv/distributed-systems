package edu.ufp.inf.sd.rmi.pingpong.server;

import edu.ufp.inf.sd.rmi.pingpong.client.PongRI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PingRI extends Remote {
    public void ping(PongRI clientPongRi, Ball  b) throws RemoteException;
}