package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {


    public CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public String methodName() throws RemoteException {
        System.out.println("Someone called me - methodName()!");
        return "Response from methodName!";
    }
}