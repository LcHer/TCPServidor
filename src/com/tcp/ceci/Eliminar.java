package com.tcp.ceci;
/**
 * 
 * @author DELL
 *
 */
public class Eliminar extends Thread{
   
	private ListaCeci list= null;

    public Eliminar(ListaCeci list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.remove();
    }
}
