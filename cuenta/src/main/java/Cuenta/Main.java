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
public class Main {

    public static void main(String[] args) {                       

        Cuenta cuenta = new Cuenta(10000);
        
        TarjetaR tarjeta1 = new TarjetaR(cuenta, 1);
        TarjetaR tarjeta2 = new TarjetaR(cuenta, 2);
        TarjetaR tarjeta3 = new TarjetaR(cuenta, 3);
        
        tarjeta1.start();
        tarjeta2.start();
        tarjeta3.start();
        
    }

}
