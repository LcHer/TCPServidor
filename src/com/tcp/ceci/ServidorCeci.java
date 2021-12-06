package com.tcp.ceci;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author DELL
 *
 */
public class ServidorCeci {

	
	public static void main(String[] args) throws InterruptedException {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 4444;

        ListaCeci list = new ListaCeci();


        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("........Servidor listo.......");

            while(true) {

                sc = servidor.accept();

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);
                if(mensaje.contains("add")) {
                    Agregar adder = new Agregar(list, mensaje.substring(4));
                    adder.start();
                    adder.join();
                    out.writeUTF(list.getlista().toString());
                    System.out.println(list.getlista().toString());
                } else if(mensaje.contains("remove")){
                    Eliminar remover = new Eliminar(list);
                    remover.start();
                    remover.join();
                    out.writeUTF(list.getlista().toString());
                    System.out.println(list.getlista().toString());
                } else {
                    out.writeUTF("Error comando incorrecto");
                }
                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCeci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}
