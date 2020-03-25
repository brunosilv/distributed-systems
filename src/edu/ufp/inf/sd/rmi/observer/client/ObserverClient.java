package edu.ufp.inf.sd.rmi.observer.client;

import  edu.ufp.inf.sd.rmi.observer.server.ObserverRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  ObserverClient {


    private SetupContextRMI contextRMI;
    private  ObserverRI myRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.exit(-1);
        } else {
            ObserverClient clt = new ObserverClient(args);
            clt.lookupService();
            clt.playService();
        }
    }

    public ObserverClient(String[] args) {
        try {
            String registryIP   = args[0];
            String registryPort = args[1];
            String serviceName  = args[2];
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(ObserverClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            Registry registry = contextRMI.getRegistry();
            if (registry != null) {
                String serviceUrl = contextRMI.getServicesUrl(0);
                myRI = (ObserverRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return myRI;
    }

    private void playService() {
        try {
            String msg=this.myRI.methodName();
            System.out.println("methodName: "+msg);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
