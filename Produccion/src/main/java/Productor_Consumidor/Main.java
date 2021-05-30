/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productor_Consumidor;

/**
 *
 * @author dani_
 */
public class Main {
    public static void main(String[] args) {
        
        Bodega bodega = new Bodega();
        
        Productor productor = new Productor(bodega);                    
        
        Consumidor consumidor1 = new Consumidor(bodega);
        Consumidor consumidor2 = new Consumidor(bodega);
        Consumidor consumidor3 = new Consumidor(bodega);
        
        productor.start();        
        consumidor1.start();
        consumidor2.start();
    }
    
}
