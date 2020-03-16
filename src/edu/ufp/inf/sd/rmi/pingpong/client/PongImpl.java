package edu.ufp.inf.sd.rmi.pingpong.client;
import edu.ufp.inf.sd.rmi.pingpong.server.Ball;
import edu.ufp.inf.sd.rmi.pingpong.server.PingRI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class PongImpl extends UnicastRemoteObject implements PongRI {

    Ball ball;
    PingRI pingRI;

    public PongImpl(int PlayerId, int rmiRegisteryPort, String rmiRegisteryIp) throws RemoteException {
        String serviceAddress = "rmi//" + rmiRegisteryPort + ":" + rmiRegisteryIp + "/PingPongService";
        try {
            pingRI = (PingRI) Naming.lookup(serviceAddress);
        } catch (MalformedURLException | NotBoundException | RemoteException ignored) {
        }
        ball = new Ball(PlayerId);
        this.startPlaying();
    }

    private void startPlaying() throws RemoteException {
        Remote exportObject = java.rmi.server.UnicastRemoteObject.exportObject(this, 0);
        pingRI.ping((PongRI) this, ball);
    }

    @Override
    public void pong(Ball b) throws RemoteException {
        Random gen = new Random();
        int plays = Math.abs(gen.nextInt(99) + 1);
        int i = 0;
        while(i <= plays ) {
            pingRI.ping((PongRI) this, b);
            i++;
        }
    }

}
