package com.tables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.beans.LiteralTableBean;
import com.beans.SymbolTableBean;

//put everything logic in this class... generate a bean and send it to the client....
public class SymbolTable {
	StringTokenizer tokenizer;

	public Hashtable<String, SymbolTableBean> generateTables(PseudoOpcodeTable pseudoOpcodeTable, Registers registers, DeclarativeStatementsTable declarativeStatementsTable, OpcodeTable opcodeTable){
		Hashtable<String, SymbolTableBean> symbolTable = new Hashtable<>();
		Hashtable<String, LiteralTableBean> literalTable = new Hashtable<>();
		String str;
		Integer symbolNumber = 0;
		Integer literalNumber = 0;
		
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
						//System.out.println("----a register");
						
						//write the register value into the file over here....
					}
					else {
						if(pseudoOpcodeTable.getPseudoOpcodeTable().containsKey(str)) {
							//System.out.println("----a pseudoOpcode");
							
							//write the contents as (AD, value) of the code into the file over here.....
						}
						else {
							if(declarativeStatementsTable.getDeclarativeStatementsTable().containsKey(str)) {
								//System.out.println("----a declarative statement");
								
								//write (DL, value) of the code into the file over here.....
							}
							else {
								if(opcodeTable.getMneumonicOpcodeTable().containsKey(str)) {
									//System.out.println("----a opcode");
									
									//write (IS, value) of the code into the file over here.....
								}
								else {
									
									Matcher literalMatcher = literalPattern.matcher(str);
									Matcher symbolMatcher = symbolPattern.matcher(str);
									Matcher locationMatcher = locationPattern.matcher(str);
									
									if(literalMatcher.find()) {
										
										if(!(literalTable.containsKey(str))) {
											LiteralTableBean literalTableBean = new LiteralTableBean();
											literalTableBean.setLiteralNumber(literalNumber);
											literalTable.put(str, literalTableBean);
											
											
											literalNumber++;
										}
										
										
										//write (L, value) of the code into the file over here....
									}
									
									else if(symbolMatcher.find()) {
										if(!(symbolTable.containsKey(str))) {
											SymbolTableBean symbolTableBean = new SymbolTableBean();
											symbolTableBean.setSymbolNumber(symbolNumber);
											symbolTable.put(str, symbolTableBean);
										
											System.out.println(str +" " +(symbolTable.get(str)).getSymbolNumber());
											symbolNumber++;
										}
									}
									
									else if(locationMatcher.find()) {
										//System.out.println("location found " +str);
										
										//set the location counter and increment it accordingly...
									}
								}
							}
						}
					}	
				}
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
