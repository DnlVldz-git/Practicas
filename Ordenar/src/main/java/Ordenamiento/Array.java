/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

/**
 *
 * @author dani_
 */
public class Array {
    private int[] array;
    
    public Array(int[] array){
        this.array = array;
    }
    
    public synchronized int[] getArray(){
        return this.array;
    }
    
    public void imprimirArray(){
        for (int i = 0; i < getArray().length; i++) {
            System.out.println(getArray()[i]);
        }
    }
    
}
