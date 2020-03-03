package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {


    public CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int soma(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public float somar(ArrayList<Float> list) throws RemoteException {
        float sum = 0;
        for (Float f : list) sum += f;
        return sum;
    }

    @Override
    public float media(ArrayList<Float> list) throws RemoteException {
        float sum = 0;
        for (Float f : list) sum += f;
        return sum/list.size();
    }

    @Override
    public float moda(ArrayList<Float> list) throws RemoteException {
        float moda = list.indexOf(Collections.max(list));
        return moda;
    }

    @Override
    public float multi(float a, float b) throws RemoteException {
        return a * b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public double potencia(double base, double exp) throws RemoteException {
        return Math.pow(base, exp);
    }

    @Override
    public float divisao(float numerador, float denominador) throws RemoteException {
        return numerador / denominador;
    }

}