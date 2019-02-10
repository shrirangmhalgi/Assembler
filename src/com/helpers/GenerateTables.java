package com.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

import com.tables.DeclarativeStatementsTable;
import com.tables.OpcodeTable;
import com.tables.PseudoOpcodeTable;
import com.tables.Registers;

public class GenerateTables {
	
	StringTokenizer tokenizer;
	String str;
	String key, value;
	
	public PseudoOpcodeTable generateAssemblerDirective() {
		Boolean flag = true;
		PseudoOpcodeTable pseudoOpcodeTable = new PseudoOpcodeTable();
		
		//1. reading the assembler directive
		File assemblerDirectiveFile = new File("assemblerDirectives.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(assemblerDirectiveFile));	
		
			while((str = br.readLine()) != null) {
				tokenizer = new StringTokenizer(str, " ");
				while(tokenizer.hasMoreTokens()) {
					if(flag) {
						key = tokenizer.nextToken();
						flag = false;
					}
					else {
						value = tokenizer.nextToken();
						flag = true;
					}
				}
				pseudoOpcodeTable.getPseudoOpcodeTable().put(key, Integer.parseInt(value));
			}
					
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
			
		return pseudoOpcodeTable;
	}
	
	public DeclarativeStatementsTable generateDeclarativeStatemenTable() {
		Boolean flag = true;
		DeclarativeStatementsTable declarativeStatementsTable = new DeclarativeStatementsTable();
		
		//2. reading the declaration statements
		File declarationStatementsFile = new File("declarationStatements.txt");
			try {
				BufferedReader br = new BufferedReader(new FileReader(declarationStatementsFile));	
					
				while((str = br.readLine()) != null) {
					tokenizer = new StringTokenizer(str, " ");
					while(tokenizer.hasMoreTokens()) {
						if(flag) {
							key = tokenizer.nextToken();
							flag = false;
						}
						else {
							value = tokenizer.nextToken();
							flag = true;
						}
					}
					declarativeStatementsTable.getDeclarativeStatementsTable().put(key, Integer.parseInt(value));
				}
				
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
		
		return declarativeStatementsTable;
	}
	
	public OpcodeTable generateOpcodeTable() {
		Boolean flag = true;
		OpcodeTable opcodeTable = new OpcodeTable();
		
		//3. reading the opcode table
		File opcodeTableFile = new File("opcodeTable.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(opcodeTableFile));	
		
			while((str = br.readLine()) != null) {
				tokenizer = new StringTokenizer(str, " ");
				while(tokenizer.hasMoreTokens()) {
					if(flag) {
						key = tokenizer.nextToken();
						flag = false;
					}
					else {
						value = tokenizer.nextToken();
						flag = true;
					}
				}
				opcodeTable.getMneumonicOpcodeTable().put(key, Integer.parseInt(value));
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return opcodeTable;
	}
	
	public Registers generateRegisterTable() {
		Boolean flag = true;
		Registers registerTable = new Registers();
		
		//4. reading the register table
		File registerFile = new File("registers.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(registerFile));	
		
			while((str = br.readLine()) != null) {
				tokenizer = new StringTokenizer(str, " ");
				while(tokenizer.hasMoreTokens()) {
					if(flag) {
						key = tokenizer.nextToken();
						flag = false;
					}
					else {
						value = tokenizer.nextToken();
						flag = true;
					}
				}
				registerTable.getRegisterTable().put(key, Integer.parseInt(value));
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		catch (IOException e) {
			e.printStackTrace();
		}
	
		return registerTable;
	}
}
