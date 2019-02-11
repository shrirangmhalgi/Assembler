package com.main;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import com.beans.LiteralTableBean;
import com.beans.SymbolTableBean;
import com.beans.WrapperBean;
import com.helpers.GenerateTables;
import com.tables.DeclarativeStatementsTable;
import com.tables.OpcodeTable;
import com.tables.PseudoOpcodeTable;
import com.tables.Registers;
import com.tables.GenerateOutputTables;

public class Main {

	
	public static void main(String[] args) {
		GenerateTables generateTables = new GenerateTables();
		
		OpcodeTable opcodeTable = generateTables.generateOpcodeTable();
		PseudoOpcodeTable pseudoOpcodeTable = generateTables.generateAssemblerDirective();
		DeclarativeStatementsTable declarativeStatementsTable = generateTables.generateDeclarativeStatemenTable();
		Registers registers = generateTables.generateRegisterTable();
		
		GenerateOutputTables generateOutputTables = new GenerateOutputTables();
		WrapperBean wrapperBean = generateOutputTables.generateTables(pseudoOpcodeTable, registers, declarativeStatementsTable, opcodeTable);
		
		//------------------SYMBOL TABLE-------------------------
		Hashtable<String, SymbolTableBean> symbolTable = wrapperBean.getSymbolTable();
		Enumeration<String> symTabKeys = symbolTable.keys();
		Enumeration<SymbolTableBean> symTabValues = symbolTable.elements();
		
		System.out.println("SymbolNo   SymbolName   Address");
		for(int i = 0; i < symbolTable.size(); i++) {
			SymbolTableBean bean = symTabValues.nextElement();
			System.out.println("   "+bean.getSymbolNumber() +"           " + symTabKeys.nextElement() + "         " +bean.getAddress());
		}
		
		//------------------LITERAL TABLE-------------------------
		Hashtable<String, LiteralTableBean> literalTable = wrapperBean.getLiteralTable();
		Enumeration<String> litTabKeys = literalTable.keys();
		Enumeration<LiteralTableBean> litTabValues = literalTable.elements();
		
		System.out.println();
		System.out.println("LiteralNo   LiteralName   Address");
		for(int i = 0; i < literalTable.size(); i++) {
			LiteralTableBean bean = litTabValues.nextElement();
			System.out.println("   "+bean.getLiteralNumber() +"           " + litTabKeys.nextElement() + "         " +bean.getAddress());
		}
	}
}
