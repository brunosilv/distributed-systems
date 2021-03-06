package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface CalculatorRI extends Remote {

    public int soma(int a, int b) throws RemoteException;
    public float somar(ArrayList<Float> list) throws RemoteException;
    public float media(ArrayList<Float> list) throws RemoteException;
    public float moda(ArrayList<Float> list) throws RemoteException;
    public float multi(float a, float b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
    public double potencia(double base, double exp) throws RemoteException;
    public float divisao(float numerador, float denominador) throws RemoteException;
}