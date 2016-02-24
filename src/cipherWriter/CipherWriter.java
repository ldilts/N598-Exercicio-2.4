package cipherWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CipherWriter extends Writer {
	
	private OutputStreamWriter outputStreamWriter;

	public CipherWriter(OutputStreamWriter outputStreamWriter) {
		
		this.outputStreamWriter = outputStreamWriter;
	}
	
	@Override
	public void write(int c) throws IOException {
		
		throw new UnsupportedOperationException("Not supported yet.");
		
	}
	
	@Override
	public void write(char[] text) throws IOException {
		
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void write(String s) throws IOException {
		
		String cipheredString = "";
		
		// Loop through all characters.
		for (char character: s.toCharArray()) {
			
			// Is the character lower case?
			if (character >= 97 && character <= 122) {
				
				char cipheredCharacter = (char) (((character - 'a' + 1) % 26) + 'a');
				cipheredString += cipheredCharacter;
				
			// Is the character upper case?
			} else if (character >= 65 && character <= 90) {
				
				char cipheredCharacter = (char) (((character - 'A' + 1) % 26) + 'A');
				cipheredString += cipheredCharacter;
				
			// Every other character should remain the same.
			} else {
				
				cipheredString += character;
				
			}
			
		}

		this.outputStreamWriter.write(cipheredString);
		this.outputStreamWriter.flush();
	}
	
	@Override
	public void write(String s, int offset, int length) throws IOException {
		
		String cipheredString = "";
		
		// Loop through the desired characters.
		for (int i = offset; i < offset + length; i++) {
			
			char character = s.charAt(i);
			
			// Is the character lower case?
			if (character >= 97 && character <= 122) {
				
				char cipheredCharacter = (char) (((character - 'a' + 1) % 26) + 'a');
				cipheredString += cipheredCharacter;
				
			// Is the character upper case?
			} else if (character >= 65 && character <= 90) {
				
				char cipheredCharacter = (char) (((character - 'A' + 1) % 26) + 'A');
				cipheredString += cipheredCharacter;
				
			// Every other character should remain the same.
			} else {
				
				cipheredString += character;
				
			}
			
		}
		
		this.outputStreamWriter.write(cipheredString);
		this.outputStreamWriter.flush();
	}

	@Override
	public void flush() throws IOException {
		
		throw new UnsupportedOperationException("Not supported yet.");
		
	}

	@Override
	public void close() throws IOException {
		
		throw new UnsupportedOperationException("Not supported yet.");
		
	}

}
