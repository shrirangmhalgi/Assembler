package com.tables;

import java.util.Hashtable;

public class Registers {
	private Hashtable<String, Integer> registerTable = new Hashtable<>();

	public Hashtable<String, Integer> getRegisterTable() {
		return registerTable;
	}

	public void setRegisterTable(Hashtable<String, Integer> registerTable) {
		this.registerTable = registerTable;
	}
}
