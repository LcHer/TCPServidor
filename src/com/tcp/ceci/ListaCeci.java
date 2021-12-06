package com.tcp.ceci;

import java.util.LinkedList;
/**
 * 
 * @author DELL
 *
 */
public class ListaCeci {
	
	private final LinkedList<String> lista = new LinkedList<>();

    public synchronized void add(String value) {
        lista.offer(value);
    }

    public synchronized String remove() {
        return lista.poll();
    }

    public LinkedList<String> getlista() {
        return this.lista;
    }

}
