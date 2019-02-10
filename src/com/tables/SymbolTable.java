package com.tables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.beans.LiteralTableBean;
import com.beans.SymbolTableBean;

public class SymbolTable {
	StringTokenizer tokenizer;

	public Hashtable<Integer, SymbolTableBean> generateSymbolTable(PseudoOpcodeTable pseudoOpcodeTable, Registers registers, DeclarativeStatementsTable declarativeStatementsTable, OpcodeTable opcodeTable){
		Hashtable<Integer, SymbolTableBean> symbolTable = new Hashtable<>();
		Hashtable<Integer, LiteralTableBean> literalTable = new Hashtable<>();
		String str;
		Integer symbolNumber = 0;
		
		//------------------ Patterns for REGEX -------------------
		Pattern literalPattern = Pattern.compile("'=*");
		Pattern locationPattern = Pattern.compile("\\d");
		Pattern symbolPattern = Pattern.compile("[a-zA-Z]");
		
		try {
			File inputFile = new File("Input.txt");
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			
			while((str = br.readLine()) != null) {
				tokenizer = new StringTokenizer(str, ", ");
				while(tokenizer.hasMoreTokens()) {
					str = tokenizer.nextToken();
					
					if(registers.getRegisterTable().containsKey(str)) {
						System.out.println("----a register");
					}
					else {
						if(pseudoOpcodeTable.getPseudoOpcodeTable().containsKey(str)) {
							System.out.println("----a pseudoOpcode");
						}
						else {
							if(declarativeStatementsTable.getDeclarativeStatementsTable().containsKey(str)) {
								System.out.println("----a declarative statement");
							}
							else {
								if(opcodeTable.getMneumonicOpcodeTable().containsKey(str)) {
									System.out.println("----a opcode");
								}
								else {
									System.out.println("-----------Symbol Found-------------");
									
									Matcher literalMatcher = literalPattern.matcher(str);
									Matcher symbolMatcher = symbolPattern.matcher(str);
									Matcher locationMatcher = locationPattern.matcher(str);
									
									if(literalMatcher.find()) {
										System.out.println("literal found " +str);
									}
									
									else if(symbolMatcher.find()) {
										System.out.println("symbol found " +str);
									}
									
									else if(locationMatcher.find()) {
										System.out.println("location found " +str);
									}
									
									//maintain a location pointer as well.
									
									//put this symbol in the symbol table along with the symbol name.
									
									
									
									SymbolTableBean symbolTableBean = new SymbolTableBean();
									symbolTableBean.setSymbolName(str);
									symbolTable.put(symbolNumber, symbolTableBean);
								
									
									
									symbolNumber++;
								}
							}
						}
					}	
				}
				System.out.println();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return symbolTable;
	}
}
