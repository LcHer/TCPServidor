package com.tcp.ceci;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author DELL
 *
 */
public class ClienteCeci {
	
	 public static void main(String[] args) {
	        final String HOST = "127.0.0.1";
	        final int PUERTO = 4444;
	        DataInputStream in;
	        DataOutputStream out;
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

	        while(true) {
	            try {
	                Socket sc = new Socket(HOST, PUERTO);

	                in = new DataInputStream(sc.getInputStream());
	                out = new DataOutputStream(sc.getOutputStream());

	                String entrada = scan.nextLine();
	                if(!entrada.equals("ADIOS")) {
	                    out.writeUTF(entrada);
	                } else {
	                    sc.close();
	                }
	                String mensaje = in.readUTF();
	                System.out.println(mensaje);
	            } catch (IOException ex) {
	                Logger.getLogger(ClienteCeci.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }

}
