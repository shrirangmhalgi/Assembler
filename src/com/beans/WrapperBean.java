package com.beans;

import java.util.Hashtable;

public class WrapperBean {
	private Hashtable<String, SymbolTableBean> symbolTable = new Hashtable<>();
	private Hashtable<String, SymbolTableBean> literalTable = new Hashtable<>();
	
	public Hashtable<String, SymbolTableBean> getSymbolTable() {
		return symbolTable;
	}
	
	public void setSymbolTable(Hashtable<String, SymbolTableBean> symbolTable) {
		this.symbolTable = symbolTable;
	}
	
	public Hashtable<String, SymbolTableBean> getLiteralTable() {
		return literalTable;
	}
	
	public void setLiteralTable(Hashtable<String, SymbolTableBean> literalTable) {
		this.literalTable = literalTable;
	}
}
