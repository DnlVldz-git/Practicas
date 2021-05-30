/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productor_Consumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class Productor extends Thread {

    private Bodega bodega;
    private Integer produccion;

    public Productor(Bodega bodega) {
        produccion = 0;
        this.setBodega(bodega);
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public void producir() throws InterruptedException {

    }

    @Override
    public void run() {
        while (true) {

            try {
                Random rnd = new Random();

                Integer produc = rnd.nextInt(20);
                Integer tiempo = (rnd.nextInt(3) + 1) * 1000;

                Thread.sleep(tiempo);

                synchronized (bodega) {
                    
                    bodega.añadirTortillas(produc);
                    System.out.println("La bodega tiene: " + bodega.mostrarTortillas() + " tortillas");
                    
                    bodega.notifyAll();
                    
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
