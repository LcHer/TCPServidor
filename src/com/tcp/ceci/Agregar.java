package com.tcp.ceci;
/**
 * 
 * @author DELL
 *
 */
public class Agregar extends Thread {
    
	private ListaCeci list=null;
    private String value = null;

    public Agregar(ListaCeci list, String value) {
        this.list = list;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public void run() {
        list.add(getValue());
    }
}
