/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class ClienteThread extends Thread {
    private Socket socket;
    private String nombre;
    String[] palabras = {"formacion", "ruptura", "placa", "chris", "amor", "endotelio", "superficie", "pelicula", "jardin", "pared"};

    public ClienteThread(Socket socket) {
        this.socket = socket;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {

            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            int i = 0;

            Random rand = new Random();

            String palabraSend = palabras[rand.nextInt(10)];

            salida.writeObject(palabraSend);

            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            String res = (String) entrada.readObject();
            if (res.equals("gane")) {
                System.out.println("El juego de "+nombre+" terminó y ha ganado");
            } else {
                System.out.println("El juego "+nombre+" terminó y ha perdido");
            }

            socket.close();

            System.out.println("Conexión con: " + nombre + " terminó");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
