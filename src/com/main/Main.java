package com.main;

import java.util.Hashtable;

import com.beans.SymbolTableBean;
import com.helpers.GenerateTables;
import com.tables.DeclarativeStatementsTable;
import com.tables.OpcodeTable;
import com.tables.PseudoOpcodeTable;
import com.tables.Registers;
import com.tables.SymbolTable;

public class Main {

	
	public static void main(String[] args) {
		GenerateTables generateTables = new GenerateTables();
		
		OpcodeTable opcodeTable = generateTables.generateOpcodeTable();
		PseudoOpcodeTable pseudoOpcodeTable = generateTables.generateAssemblerDirective();
		DeclarativeStatementsTable declarativeStatementsTable = generateTables.generateDeclarativeStatemenTable();
		Registers registers = generateTables.generateRegisterTable();
		
		SymbolTable symbolTable = new SymbolTable();
		Hashtable<Integer, SymbolTableBean> symTable = symbolTable.generateSymbolTable(pseudoOpcodeTable, registers, declarativeStatementsTable, opcodeTable);
		
		
	}
}
