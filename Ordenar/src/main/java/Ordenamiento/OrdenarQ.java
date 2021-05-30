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
public class OrdenarQ extends Thread{
    private int[] array;
    private JProgressBar pgr;
    private int progreso;
    private Array arrayClase;
    
    public OrdenarQ(Array array){
        this.arrayClase = array;        
        this.progreso = 0;
    }
    
    public void setPgrs(JProgressBar pgrs){
        this.pgr = pgrs;
    }

    public void intercambio(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void completar(){
        if ((progreso != numComparaciones())) {
            this.pgr.setValue(progreso);
            progreso+=1;
        }
    }
    
    public static int log2(int n)
    {
        int result = (int)(Math.log(2) / Math.log(2));
  
        return result;
    }
    
    public int numComparaciones(){
        return (int)arrayClase.getArray().length*(log2(arrayClase.getArray().length));
    }
    
    public int particion(int[] array, int minimo, int maximo) {       
        int pivot = array[maximo];
        int i = (minimo - 1);

        for (int j = minimo; j <= maximo - 1; j++) {
            if (array[j] < pivot) {
                i++;
                intercambio(array, i, j);
            }
        }
        intercambio(array, i + 1, maximo);
        return (i + 1);
    }
    
    public void ordenar(int[] array, int minimo, int maximo) {
        completar();
        if (minimo < maximo) {           
            int pi = particion(array, minimo, maximo);
            ordenar(array, minimo, pi - 1);
            ordenar(array, pi + 1, maximo);
        }
        System.out.println("termine");
    }

    @Override
    public void run() {
        ordenar(this.arrayClase.getArray(), 0, this.arrayClase.getArray().length-1);
    }
    
    

}
