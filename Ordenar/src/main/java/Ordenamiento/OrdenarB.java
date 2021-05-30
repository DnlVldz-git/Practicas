/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import javax.swing.JProgressBar;

/**
 *
 * @author dani_
 */
public class OrdenarB extends Thread{
    private int[] array;
    private JProgressBar pgr;
    private int progreso;
    private Array arrayClase;
    
    public OrdenarB(Array array){
        this.arrayClase = array;        
        this.progreso = 0;
    }
    
    public void metodo() {
        int n = arrayClase.getArray().length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayClase.getArray()[j] > arrayClase.getArray()[j + 1]) {
                    int temp = arrayClase.getArray()[j];
                    arrayClase.getArray()[j] = arrayClase.getArray()[j + 1];
                    arrayClase.getArray()[j + 1] = temp;
                }
                completar();
            }
        }          
        System.out.println("Terminé");
    }
    
    public void completar(){
        if (progreso <= numComparaciones()) {
            this.pgr.setValue(progreso);
            progreso++;
        }
    }
    
    public void setPgrs(JProgressBar pgrs){
        this.pgr = pgrs;
    }
            
    public int numComparaciones(){
        return (int)((((Math.pow(arrayClase.getArray().length, 2)) - arrayClase.getArray().length) / 2) / 10);
    }
    
    public int[] getArray(){
        return this.arrayClase.getArray();
    }

    @Override
    public void run() {
        metodo();        
    }
    
    
    
}
