/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dani_
 */
public class ElegirDialog extends JDialog{
    private JPanel pnl;
    private JLabel lbl;
    private JButton btnQ;
    private JButton btnB;
    
    public ElegirDialog(){
        super.setSize(300, 330);
        super.setLocationRelativeTo(null);
        
        this.pnl = new JPanel();
        this.lbl = new JLabel("Elige el método de ordenamiento");
        this.btnQ = new JButton("Quick Sort");
        this.btnB = new JButton("Bubble Sort");
        
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        
        pnl.add(this.lbl);
        pnl.add(this.btnQ);
        pnl.add(this.btnB);        
        
        add(pnl);
    }

    public JButton getBtnQ() {
        return btnQ;
    }

    public JButton getBtnB() {
        return btnB;
    }
    
    
    
}
