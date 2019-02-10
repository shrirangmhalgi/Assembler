//assembler directives

package com.tables;

import java.util.Hashtable;

public class PseudoOpcodeTable {
	private Hashtable<String, Integer> pseudoOpcodeTable = new Hashtable<>();

	public Hashtable<String, Integer> getPseudoOpcodeTable() {
		return pseudoOpcodeTable;
	}

	public void setPseudoOpcodeTable(Hashtable<String, Integer> pseudoOpcodeTable) {
		this.pseudoOpcodeTable = pseudoOpcodeTable;
	}
}
