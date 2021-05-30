/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dani_
 */
public class AhorcadoPanel extends JPanel{
    private JLabel lblImg;
    private JButton btn;
    private JTextField txtFld;
    private JPanel pnlLabels;
    private JPanel pnlFoto;
    private JPanel pnlResto;
    private JPanel pnlTxtFld;
    private JPanel pnlLbl;   
    private JPanel pnlBtn;
    private ArrayList<JLabel> letras;
    private char[] palabra;
    
    public AhorcadoPanel(String palabra){
        this.palabra = new char[palabra.length()];
        this.letras = new ArrayList();
        this.btn = new JButton("Checar");
        this.pnlLabels = new JPanel();
        this.pnlFoto = new JPanel();
        this.pnlResto = new JPanel();
        this.pnlLbl = new JPanel();
        this.pnlBtn = new JPanel();
        this.pnlTxtFld = new JPanel();
        this.txtFld = new JTextField(1);
        
        
        pnlResto.setLayout(new BoxLayout(pnlResto, BoxLayout.Y_AXIS));
        
        llenarArray(palabra);
        crearArrayList(palabra);        
        
        ImageIcon icon = new ImageIcon("0.png");
        
        this.lblImg = new JLabel();
        this.lblImg.setIcon(icon);
        
        pnlFoto.add(this.lblImg, BorderLayout.NORTH);                
        
        for (JLabel letra : letras) {
            pnlLabels.add(letra, BorderLayout.NORTH);
        }       
        
        this.pnlLbl.add(pnlLabels, BorderLayout.NORTH);
        
        this.pnlTxtFld.add(txtFld);
        
        this.pnlBtn.add(btn);
        
        this.pnlResto.add(pnlLbl);
        this.pnlResto.add(pnlTxtFld);
        this.pnlResto.add(pnlBtn);
        
        this.add(this.pnlFoto, BorderLayout.NORTH);
        
        this.add(pnlResto, BorderLayout.SOUTH);                
    }
    
    public void cleanLabel(int index){
        letras.get(index).setText("_");
    }
    
    public void setLabel(int index, String letra){
        letras.get(index).setText(letra);
    }
    
    public JTextField getTxtFld(){
        return this.txtFld;
    }
    
    public char[] getPalabra(){
        return this.palabra;
    }
    
    public JLabel getImgLbl(){
        return this.lblImg;
    }
    
    public boolean checarLetra(int index, char letra){
        if (palabra[index] == letra) {
            return true;
        }else{
            return false;
        }
    }            

    public ArrayList<JLabel> getLetras() {
        return letras;
    }

    public JButton getBtn() {
        return btn;
    }
    
    public void crearArrayList(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            JLabel field = new JLabel("_");
            this.letras.add(field);
        }
    }
    
    public void llenarArray(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
            this.palabra[i] = palabra.charAt(i);
        }
    }
    
    
    
    
}
