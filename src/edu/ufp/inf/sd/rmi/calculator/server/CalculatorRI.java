package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface CalculatorRI extends Remote {
    public String methodName() throws RemoteException;

    /*public int soma(int a, int b) throws RemoteException;
    public float somar(ArrayList<Float> list) throws RemoteException;
    public float media(ArrayList<Float> list) throws RemoteException;
    public float moda(ArrayList<Float> list) throws RemoteException;
    public float multi(float a, float b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
    public float potencia(float base, float exp) throws RemoteException;
    public float divisao(float numerador, float denominador) throws RemoteException;*/
}