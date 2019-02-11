package com.beans;

import java.util.Hashtable;

public class WrapperBean {
	private Hashtable<String, SymbolTableBean> symbolTable = new Hashtable<>();
	private Hashtable<String, LiteralTableBean> literalTable = new Hashtable<>();
	
	public Hashtable<String, SymbolTableBean> getSymbolTable() {
		return symbolTable;
	}
	
	public void setSymbolTable(Hashtable<String, SymbolTableBean> symbolTable) {
		this.symbolTable = symbolTable;
	}
	
	public Hashtable<String, LiteralTableBean> getLiteralTable() {
		return literalTable;
	}
	
	public void setLiteralTable(Hashtable<String, LiteralTableBean> literalTable) {
		this.literalTable = literalTable;
	}
}
