package edu.ufp.inf.sd.rmi.calculator.client;

import  edu.ufp.inf.sd.rmi.calculator.server.CalculatorRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  CalculatorClient {


    private SetupContextRMI contextRMI;
    private  CalculatorRI myRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.exit(-1);
        } else {
            CalculatorClient clt = new CalculatorClient(args);
            clt.lookupService();
            clt.playService();
        }
    }

    public CalculatorClient(String[] args) {
        try {
            String registryIP   = args[0];
            String registryPort = args[1];
            String serviceName  = args[2];
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            Registry registry = contextRMI.getRegistry();
            if (registry != null) {
                String serviceUrl = contextRMI.getServicesUrl(0);
                myRI = (CalculatorRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return myRI;
    }

    private void playService() {
        ArrayList<Float> list = new ArrayList<Float>();
        list.add((float) 1);
        list.add((float) 2);
        list.add((float) 2);
        list.add((float) 5);

        int a = 5;
        int b = 4;
        try {
            int result=this.myRI.soma(a, b);
            System.out.println("sum: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            int result=this.myRI.sub(a, b);
            System.out.println("sub: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            float result=this.myRI.multi(a, b);
            System.out.println("multi: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            float result=this.myRI.divisao(a, b);
            System.out.println("div: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            float result=this.myRI.somar(list);
            System.out.println("sum list: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            float result=this.myRI.media(list);
            System.out.println("med: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            float result=this.myRI.moda(list);
            System.out.println("mod: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            double result=this.myRI.potencia(a,b);
            System.out.println("pot: "+result);
        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
