/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dani_
 */
public class PeticionPanel extends JPanel {

    private JTextField txtFld;
    private JButton btn;
    private JButton btnPrint;
    private JLabel lbl;

    public PeticionPanel() {
        this.txtFld = new JTextField(10);
        this.btn = new JButton("Aceptar");
        this.btnPrint = new JButton("Imprimir");
        this.lbl = new JLabel("ingrese los numero a ordenar");

        
        super.add(this.txtFld);
        super.add(this.btn);
        super.add(this.btnPrint);
        super.add(this.lbl);
    }

    public JButton getBtn() {
        return this.btn;
    }
    
    public JButton getBtnPrint(){
        return this.btnPrint;
    }

    public JTextField getFld() {
        return this.txtFld;
    }

    public int getNum() {
        return Integer.getInteger(this.txtFld.getText());
    }

    public void cleanFld() {
        this.txtFld.setText("");
    }

}
