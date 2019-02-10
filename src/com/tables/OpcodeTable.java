package com.tables;

import java.util.Hashtable;

public class OpcodeTable {
	private Hashtable<String, Integer> mneumonicOpcodeTable = new Hashtable<>();

	public Hashtable<String, Integer> getMneumonicOpcodeTable() {
		return mneumonicOpcodeTable;
	}

	public void setMneumonicOpcodeTable(Hashtable<String, Integer> mneumonicOpcodeTable) {
		this.mneumonicOpcodeTable = mneumonicOpcodeTable;
	}
}
