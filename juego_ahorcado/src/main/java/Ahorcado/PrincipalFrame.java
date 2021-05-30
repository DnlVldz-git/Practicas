/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author dani_
 */
public class PrincipalFrame extends JFrame {

    private AhorcadoPanel panel;
    private int intento, iguales;
    private Socket socket;
    private ObjectInputStream entrada;

    private Boolean sem;

    public PrincipalFrame(int puerto) {
        super("Ahorcado");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 380);
        super.setLocationRelativeTo(null);

        while (true) {
            try {
                socket = new Socket("127.0.0.1", 1131);

                System.out.println("Me aceptaron");

                entrada = new ObjectInputStream(socket.getInputStream());

                intento = 0;
                iguales = 0;

                panel = new AhorcadoPanel((String) entrada.readObject());
                break;
            } catch (IOException ex) {
                System.out.println("Error al conectar o esperando");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error o esperando");
            }
        }

        ButtonActionListener e = new ButtonActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cont = 0;
                if (panel.getTxtFld().getText().equals("")) {
                    JOptionPane.showMessageDialog(panel, "Introduzca una letra");
                } else {
                    for (int i = 0; i < panel.getPalabra().length; i++) {
                        if ((panel.getTxtFld().getText().charAt(0) == panel.getPalabra()[i]) && !(String.valueOf(panel.getTxtFld().getText().charAt(0)).equals(panel.getLetras().get(i).getText()))) {
                            panel.getLetras().get(i).setText(String.valueOf(panel.getPalabra()[i]));
                            iguales++;
                            cont++;
                        }
                        if (iguales == panel.getPalabra().length) {
                            JOptionPane.showMessageDialog(panel, "Ha ganado");
                            try {
                                ObjectOutputStream salida =  new ObjectOutputStream(socket.getOutputStream());
                                salida.writeObject("gane");
                            } catch (IOException ex) {
                                Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            try {
                                socket.close();
                            } catch (IOException ex) {
                                Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.exit(1);
                        }
                    }
                    panel.getTxtFld().setText("");
                    if (cont == 0) {
                        intento++;
                        panel.getTxtFld().setText("");
                        ImageIcon icon = new ImageIcon(intento + ".png");
                        panel.getImgLbl().setIcon(icon);
                        if (intento == 4) {
                            try {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                JOptionPane.showMessageDialog(panel, "Ha perdido");
                                ObjectOutputStream salida =  new ObjectOutputStream(socket.getOutputStream());
                                salida.writeObject("perdi");
                                socket.close();
                                System.exit(1);
                            } catch (IOException ex) {
                                Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }

                ArrayList<JLabel> letras = panel.getLetras();

            }

        };

        panel.getBtn().addActionListener(e);
        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame(400);
            }
        });
    }

}
