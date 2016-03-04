package cipherWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

public class CipherWriter extends Writer {
	
	private OutputStreamWriter outputStreamWriter;
	
	private final char[] lowerVowels = { 'a', 'e', 'i', 'o', 'u' };
	private final char[] upperVowels = { 'A', 'E', 'I', 'O', 'U' };
	
	// = = = = = = =  CipherWriter Methods  = = = = = = =

	public CipherWriter(OutputStreamWriter outputStreamWriter) {
		this.outputStreamWriter = outputStreamWriter;
	}
	
	private String cipherText(char[] text) {
		char[] cipheredChars = new char[text.length];
		
		// Loop through all characters.
		for (int i = 0; i < text.length; i++) {
			
			char character = text[i];
			
			if (this.isLowerCase(character)) {
				if (new String(this.lowerVowels).indexOf(character) != -1) {
					// Lower case vowels
					for (int j = 0; j < this.lowerVowels.length; j++) {
						if (this.lowerVowels[j] == character) {
							j++;
							
							if (j >= this.lowerVowels.length) {
								j = 0;
							}
							
							character = this.lowerVowels[j];
							break;
						}
					}
				} else {
					// Lower case consonants
					character = this.getNextChar(character, true);
					
					if (new String(this.lowerVowels).indexOf(character) != -1) {
						character = this.getNextChar(character, true);
					}
				}
			} else if (this.isUpperCase(character)) {
				if (new String(this.upperVowels).indexOf(character) != -1) {
					// Upper case vowels
					for (int j = 0; j < this.upperVowels.length; j++) {
						if (this.upperVowels[j] == character) {
							j++;
							
							if (j >= this.upperVowels.length) {
								j = 0;
							}
							
							character = this.upperVowels[j];
							break;
						}
					}
				} else {
					// Upper case consonants
					character = this.getNextChar(character, false);
					
					if (new String(this.upperVowels).indexOf(character) != -1) {
						character = this.getNextChar(character, false);
					}
				}
			} 
			
			cipheredChars[i] = character;
		}
		
		return String.valueOf(cipheredChars);
	}
	
	private boolean isLowerCase(char character) {
		// Is the character lower case?
		if (character >= 97 && character <= 122) {
			return true;
		}
	
		return false;
	}
	
	private boolean isUpperCase(char character) {
		// Is the character upper case?
		if (character >= 65 && character <= 90) {
			return true;
		}
	
		return false;
	}
	
	private char getNextChar(char character, boolean isLowerCase) {
		if (isLowerCase) {
			return (char) (((character - 'a' + 1) % 26) + 'a');
		} else {
			return (char) (((character - 'A' + 1) % 26) + 'A');
		}
	}
	
	// = = = = = = =  Write Methods  = = = = = = =
	
	@Override
	public void write(int c) throws IOException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void write(char[] text) throws IOException {
		String cipheredText = this.cipherText(text);
		this.outputStreamWriter.write(cipheredText);
		this.flush();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		char[] chosenChars = new char[len];
		
		// Get desired chars
		for (int i = off; i < len; i++) {
			char character = cbuf[i];
			chosenChars[i] = character;
		}
		
		String cipheredText =  this.cipherText(chosenChars);
		this.outputStreamWriter.write(cipheredText);
		this.flush();
	}
	
	@Override
	public void write(String s) throws IOException {
		String cipheredText = this.cipherText(s.toCharArray());
		this.outputStreamWriter.write(cipheredText);
		this.flush();
	}
	
	@Override
	public void write(String s, int offset, int length) throws IOException {
		char[] cbuf = s.toCharArray();
		char[] chosenChars = new char[length];
		
		// Get desired chars
		for (int i = offset; i < length; i++) {
			char character = cbuf[i];
			chosenChars[i] = character;
		}
		
		String cipheredText =  this.cipherText(chosenChars);
		this.outputStreamWriter.write(cipheredText);
		this.flush();
	}

	@Override
	public void flush() throws IOException {
		this.outputStreamWriter.flush();
	}

	@Override
	public void close() throws IOException {
		this.outputStreamWriter.close();
	}
}
