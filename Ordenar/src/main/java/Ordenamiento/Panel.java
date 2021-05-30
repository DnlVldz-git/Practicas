/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author dani_
 */
public class Panel extends JPanel {

    private JProgressBar pgrs1;
    private JProgressBar pgrs2;
    private JProgressBar pgrs3;
    private JProgressBar pgrs4;
    private JProgressBar pgrs5;
    private JProgressBar pgrs6;
    private JProgressBar pgrs7;
    private JProgressBar pgrs8;
    private JProgressBar pgrs9;
    private JProgressBar pgrs10;
    private OrdenarB o1;
    private OrdenarB o2;
    private OrdenarB o3;
    private OrdenarB o4;
    private OrdenarB o5;
    private OrdenarB o6;
    private OrdenarB o7;
    private OrdenarB o8;
    private OrdenarB o9;

    private OrdenarB o10;
    private OrdenarQ oq1;
    private OrdenarQ oq2;
    private OrdenarQ oq3;
    private OrdenarQ oq4;
    private OrdenarQ oq5;
    private OrdenarQ oq6;
    private OrdenarQ oq7;
    private OrdenarQ oq8;
    private OrdenarQ oq9;
    private OrdenarQ oq10;
    private Integer tamArreglo;
    private int[] array;
    private char letra;
    private Array arrayClase;
    

    public Panel(Integer numNumeros, char letra) {
        this.letra = letra;

        hacerArreglo(numNumeros);

        instanciarPgrs();

        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(this.pgrs1);
        add(this.pgrs2);
        add(this.pgrs3);
        add(this.pgrs4);
        add(this.pgrs5);
        add(this.pgrs6);
        add(this.pgrs7);
        add(this.pgrs8);
        add(this.pgrs9);
        add(this.pgrs10);
    }
    
    public Array getArray(){
        return arrayClase;
    }

    public void hacerArreglo(Integer num) {
        Random rnd = new Random();
        //this.tamArreglo = Math.round(num / 10);

        //arrays = new ArrayList();

        this.array = new int[num];
        
        for (int i = 0; i < num; i++) {
            array[i] = rnd.nextInt(100);
        }
        
        arrayClase = new Array(array);
    }
    
    public void crearArray(){
        
    }

    public void instanciarPgrs() {
        if (letra == 'b') {
            o1 = new OrdenarB(arrayClase);
            this.pgrs1 = new JProgressBar(0, o1.numComparaciones());
            o1.setPgrs(pgrs1);
            pgrs1.setValue(0);

            o2 = new OrdenarB(arrayClase);
            this.pgrs2 = new JProgressBar(0, o2.numComparaciones());
            o2.setPgrs(pgrs2);
            pgrs2.setValue(0);

            o3 = new OrdenarB(arrayClase);
            this.pgrs3 = new JProgressBar(0, o3.numComparaciones());
            o3.setPgrs(pgrs3);
            pgrs3.setValue(0);

            o4 = new OrdenarB(arrayClase);
            this.pgrs4 = new JProgressBar(0, o4.numComparaciones());
            o4.setPgrs(pgrs4);
            pgrs4.setValue(0);

            o5 = new OrdenarB(arrayClase);
            this.pgrs5 = new JProgressBar(0, o5.numComparaciones());
            o5.setPgrs(pgrs5);
            pgrs5.setValue(0);

            o6 = new OrdenarB(arrayClase);
            this.pgrs6 = new JProgressBar(0, o6.numComparaciones());
            o6.setPgrs(pgrs6);
            pgrs6.setValue(0);

            o7 = new OrdenarB(arrayClase);
            this.pgrs7 = new JProgressBar(0, o7.numComparaciones());
            o7.setPgrs(pgrs7);
            pgrs7.setValue(0);

            o8 = new OrdenarB(arrayClase);
            this.pgrs8 = new JProgressBar(0, o8.numComparaciones());
            o8.setPgrs(pgrs8);
            pgrs8.setValue(0);

            o9 = new OrdenarB(arrayClase);
            this.pgrs9 = new JProgressBar(0, o9.numComparaciones());
            o9.setPgrs(pgrs9);
            pgrs9.setValue(0);

            o10 = new OrdenarB(arrayClase);
            this.pgrs10 = new JProgressBar(0, o10.numComparaciones());
            o10.setPgrs(pgrs10);
            pgrs10.setValue(0);

        } else if (letra == 'q') {

            oq1 = new OrdenarQ(arrayClase);
            this.pgrs1 = new JProgressBar(0, oq1.numComparaciones());
            oq1.setPgrs(pgrs1);
            pgrs1.setValue(0);

            oq2 = new OrdenarQ(arrayClase);
            this.pgrs2 = new JProgressBar(0, oq2.numComparaciones());
            oq2.setPgrs(pgrs2);
            pgrs2.setValue(0);

            oq3 = new OrdenarQ(arrayClase);
            this.pgrs3 = new JProgressBar(0, oq3.numComparaciones());
            oq3.setPgrs(pgrs3);
            pgrs3.setValue(0);

            oq4 = new OrdenarQ(arrayClase);
            this.pgrs4 = new JProgressBar(0, oq4.numComparaciones());
            oq4.setPgrs(pgrs4);
            pgrs4.setValue(0);

            oq5 = new OrdenarQ(arrayClase);
            this.pgrs5 = new JProgressBar(0, oq5.numComparaciones());
            oq5.setPgrs(pgrs5);
            pgrs5.setValue(0);

            oq6 = new OrdenarQ(arrayClase);
            this.pgrs6 = new JProgressBar(0, oq6.numComparaciones());
            oq6.setPgrs(pgrs6);
            pgrs6.setValue(0);

            oq7 = new OrdenarQ(arrayClase);
            this.pgrs7 = new JProgressBar(0, oq7.numComparaciones());
            oq7.setPgrs(pgrs7);
            pgrs7.setValue(0);

            oq8 = new OrdenarQ(arrayClase);
            this.pgrs8 = new JProgressBar(0, oq8.numComparaciones());
            oq8.setPgrs(pgrs8);
            pgrs8.setValue(0);

            oq9 = new OrdenarQ(arrayClase);
            this.pgrs9 = new JProgressBar(0, oq9.numComparaciones());
            oq9.setPgrs(pgrs9);
            pgrs9.setValue(0);

            oq10 = new OrdenarQ(arrayClase);
            this.pgrs10 = new JProgressBar(0, oq10.numComparaciones());
            oq10.setPgrs(pgrs10);
            pgrs10.setValue(0);
        }

        pgrs1.setStringPainted(true);
        pgrs2.setStringPainted(true);
        pgrs3.setStringPainted(true);
        pgrs4.setStringPainted(true);
        pgrs5.setStringPainted(true);
        pgrs6.setStringPainted(true);
        pgrs7.setStringPainted(true);
        pgrs8.setStringPainted(true);
        pgrs9.setStringPainted(true);
        pgrs10.setStringPainted(true);
    }

    public void empezar() {
        if (letra == 'b') {
            o1.start();
            o2.start();
            o3.start();
            o4.start();
            o5.start();
            o6.start();
            o7.start();
            o8.start();
            o9.start();
            o10.start();
        } else {
            oq1.start();
            oq2.start();
            oq3.start();
            oq4.start();
            oq5.start();
            oq6.start();
            oq7.start();
            oq8.start();
            oq9.start();
            oq10.start();
        }
    }
    
    public void clean(){
        pgrs1.setValue(0);
        pgrs2.setValue(0);
        pgrs3.setValue(0);
        pgrs4.setValue(0);
        pgrs5.setValue(0);
        pgrs6.setValue(0);
        pgrs7.setValue(0);
        pgrs8.setValue(0);
        pgrs9.setValue(0);
        pgrs10.setValue(0);
    }

}
