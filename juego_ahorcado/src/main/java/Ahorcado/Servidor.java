/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class Servidor {

    public static void main(String[] args) {

        try {
            
            ServerSocket server = new ServerSocket(1131);

            while (true) {
                Socket socket = server.accept();
                ClienteThread nuevo = new ClienteThread(socket);
                nuevo.setNombre(nuevo.getName());
                System.out.println("Conexion establecida con: " + nuevo.getName());
                nuevo.start();
            }

            //server.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
