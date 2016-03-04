package main;

import java.io.IOException;
import java.io.OutputStreamWriter;

import cipherWriter.CipherWriter;

public class Main {

	private static CipherWriter cipherWriter;

	public static void main(String[] args) {
		
		System.out.println("\nLet's begin!\n");
		
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
		cipherWriter = new CipherWriter(outputStreamWriter);
		
		try {
			cipherWriter.write("Hello World");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n");
		
		try {
			cipherWriter.write("Hello World", 3, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n");
		
		char[] characterArray = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
//		char[] characterArray = { 'A', 'E', 'I', 'O', 'U' };
			
//			{ 'B', 'C', 'D', 'F',
//				'G', 'H', 'J', 'K', 'L', 'M',
//	            'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z' };
			
//			{ 'a', 'e', 'i', 'o', 'u' };
		
//			{ 'b', 'c', 'd', 'f',
//				'g', 'h', 'j', 'k', 'l', 'm',
//	            'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
		
		try {
			cipherWriter.write(characterArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n");
		
		try {
			cipherWriter.write(characterArray, 3, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
