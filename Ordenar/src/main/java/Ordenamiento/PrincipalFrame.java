/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author dani_
 */
public class PrincipalFrame extends JFrame {

    private Panel pnl;
    private PeticionPanel petiPnl;
    private ElegirDialog eleDlg;
    private char letra;

    public PrincipalFrame() {
        super("Ordenamiento");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 500);
        super.setLocationRelativeTo(null);

        this.petiPnl = new PeticionPanel();
        this.eleDlg = new ElegirDialog();

        BtnActionListener e = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                if (petiPnl.getFld().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Introduzca un número válido");
                    petiPnl.cleanFld();                
                }else if(pnl == null){
                    Integer num = Integer.valueOf(petiPnl.getFld().getText());
                    pnl = new Panel(num, letra);
                    add(pnl, BorderLayout.SOUTH);
                    pack();                    
                    pnl.empezar();
                    
                }else{
                    remove(pnl);
                    Integer num = Integer.valueOf(petiPnl.getFld().getText());
                    pnl = new Panel(num, letra);
                    add(pnl, BorderLayout.SOUTH);
                    pack();
                    pnl.empezar();     
                }                   
            }
        };
        
        BtnActionListener eB = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                letra = 'b';
                eleDlg.setVisible(false);
                setVisible(true);
            }
        };
        
        BtnActionListener eQ = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                letra = 'q';
                eleDlg.setVisible(false);
                setVisible(true);
            }
        };
        
         BtnActionListener imprimir = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnl.getArray().imprimirArray();
            }
        };
        
        
        
        petiPnl.getBtn().addActionListener(e);
        petiPnl.getBtnPrint().addActionListener(imprimir);
        eleDlg.getBtnB().addActionListener(eB);
        eleDlg.getBtnQ().addActionListener(eQ);
        
        
        eleDlg.setVisible(true);
        eleDlg.pack();
        add(this.petiPnl, BorderLayout.NORTH);
        pack();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();
            }
        });
    }

}
