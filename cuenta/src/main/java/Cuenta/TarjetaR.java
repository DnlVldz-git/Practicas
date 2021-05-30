/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuenta;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class TarjetaR extends Thread {

    private Cuenta cuenta;
    private int numTarjeta;

    public TarjetaR(Cuenta cuenta, int num) {
        this.cuenta = cuenta;
        this.numTarjeta = num;
    }

    public long retirar() {
        int multiplo = (int) (Math.random() * 8 + 1);

        if (cuenta.verDinero(numTarjeta) <= (multiplo * 1000)) {
            System.out.println("No day dinero suficiente");
            
            return 0;
        } else {
            cuenta.retirar(multiplo * 1000);
            
            return (multiplo * 1000);
        }      
    }

    public long depositar() {
        int multiplo = (int) (Math.random() * 4 + 1);
        cuenta.depositar(multiplo * 1000);
        return (multiplo * 1000);

    }

    @Override
    public void run() {
        while (true) {
            int num = (int) (Math.random() * 3 + 1);
            
            switch (num) {
                case 1:
                    System.out.println("La tarjeta " + numTarjeta + " depositó: " + depositar());
                    break;
                case 2:
                case 3:
                    System.out.println("La tarjeta " + numTarjeta + " retiró: " + retirar());                    
                    break;
                default:
                    throw new AssertionError();
            }                        

            System.out.println("Dinero en la cuenta: " + cuenta.verDinero(numTarjeta));
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(TarjetaR.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
