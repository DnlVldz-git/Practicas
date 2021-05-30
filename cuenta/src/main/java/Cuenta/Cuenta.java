/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuenta;

/**
 *
 * @author dani_
 */
public class Cuenta {
    private long dinero;
    
    public Cuenta(long dinero){
        this.dinero = dinero;        
    }
    
    public void retirar(long cantidad){
        dinero =  dinero - cantidad;
    }
    
    public synchronized long verDinero(int num){
        return dinero;
    }
    
    public  void depositar(long cantidad){
        this.dinero = dinero + cantidad;
    }
    
}
