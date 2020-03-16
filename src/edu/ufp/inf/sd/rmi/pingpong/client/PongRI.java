package edu.ufp.inf.sd.rmi.pingpong.client;

import edu.ufp.inf.sd.rmi.pingpong.server.Ball;

import java.rmi.RemoteException;

public interface PongRI {
    public void pong(Ball b) throws RemoteException;
}
