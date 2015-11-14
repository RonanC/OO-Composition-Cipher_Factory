package ie.gmit.sw;

import java.security.*;

import javax.crypto.*;

public class SymmetricCypher extends AbstractCypher {
	private Key k;
	
	public SymmetricCypher(Cipher c, String algorithm, int bits) throws Throwable {
		super(c);
		KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
		keyGen.init(bits);
		this.k = keyGen.generateKey();
	}

	protected void switchKey() throws Throwable {
		super.setKey(k);
	}
}
