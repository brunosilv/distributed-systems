package edu.ufp.inf.sd.rmi.pingpong.server;

import java.io.Serializable;

public class Ball implements Serializable {
    public int PlayerId;

    public Ball(int PlayerId) {
        this.PlayerId = PlayerId;
    }

    public int getPlayerId() {
        return PlayerId;
    }
}
