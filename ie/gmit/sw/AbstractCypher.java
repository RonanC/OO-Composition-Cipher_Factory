package ie.gmit.sw;

import javax.crypto.*;
import java.security.*;

public abstract class AbstractCypher implements Cypherable {
	private Cipher cypher;
	private Key key;

	public AbstractCypher(Cipher c) throws Throwable {
		super();
		this.cypher = c;
	}
	
	// wouldn't usually use this, just used as an example used
	protected abstract void switchKey() throws Throwable;
	
	public byte[] encrypt(byte[] plainText) throws Throwable {
		switchKey();
		// anybody can use this method, ie public
		cypher.init(Cipher.ENCRYPT_MODE, key);
		return cypher.doFinal(plainText);
	}

	public byte[] decrypt(byte[] cypherText) throws Throwable {
		switchKey();
		// private key for decyphering
		cypher.init(Cipher.DECRYPT_MODE, key);
		return cypher.doFinal(cypherText);
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}