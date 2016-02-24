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
			cipherWriter.write("Lucas Dilts 123");
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

	}

}
