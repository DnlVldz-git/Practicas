package PingPong;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dani_
 */
public class PingPong {

    public static void main(String[] args) {
        
        Semaforo semaforo = new Semaforo();        
        
        Ping ping = new Ping(semaforo);
        Pong pong = new Pong(semaforo);
        
        ping.start();
        pong.start();
    }
}
