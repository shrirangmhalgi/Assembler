 package com.tables;

import java.util.Hashtable;

import com.beans.LiteralTableBean;

public class LiteralTable {
	private Hashtable<String, LiteralTableBean> literalTable = new Hashtable<>();

	public Hashtable<String, LiteralTableBean> getLiteralTable() {
		return literalTable;
	}

	public void setLiteralTable(Hashtable<String, LiteralTableBean> literalTable) {
		this.literalTable = literalTable;
	}
}
