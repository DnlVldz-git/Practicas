package PingPong;



import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dani_
 */
public class Ping extends Thread {

    private Semaforo semaforo;    

    public Ping(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(70);
                if (!semaforo.isSemaforo()) {
                    System.out.println("PING");
                    semaforo.setSemaforo(true);
                }
                yield();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ping.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
