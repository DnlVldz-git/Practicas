/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productor_Consumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class Bodega {

    private int tortillas;

    public Bodega() {
        this.tortillas = 0;
    }

    public synchronized void añadirTortillas(int num_t) {
        this.tortillas = mostrarTortillas() + num_t;
    }

    public synchronized int mostrarTortillas() {
        return this.tortillas;
    }

    public boolean darTortillas(int num_t) {
        if (num_t <= mostrarTortillas()) {
            synchronized (getClass()) {
                this.tortillas = mostrarTortillas() - num_t;
            }
            return true;
        } else {
            return false;
        }

    }

}
