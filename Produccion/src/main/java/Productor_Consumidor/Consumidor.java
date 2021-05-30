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
public class Consumidor extends Thread {

    private Integer solicitud;
    private Bodega bodega;

    public Consumidor(Bodega bodega) {
        Random rnd = new Random();
        this.solicitud = rnd.nextInt(21) + 1;
        this.setBodega(bodega);
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Integer getSolicitud() {
        return this.solicitud;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " pidió: " + solicitud + " tortillas porfa");
            synchronized (bodega) {
                while (true) {
                    if (bodega.darTortillas(solicitud)) {
                        System.out.println(this.getName() + " Me despachó " + this.solicitud + " tortillas");

                        break;
                    } else {
                        System.out.println("Esperaré...");
                        try {
                            bodega.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                Random rnd = new Random();
                this.solicitud = rnd.nextInt(21) + 1;
            }

            try {
                Thread.sleep(1000);
            } catch (Throwable ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
