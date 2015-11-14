package ie.gmit.sw;

import javax.crypto.Cipher;

public class CypherFactory {
	private static CypherFactory cf = new CypherFactory();	// Eager singleton
	
	// private factory
	private CypherFactory() {
		
	}
	
	// singleton method
	public static CypherFactory getInstance() {
		return cf;
	}
	
	// factory method
	public Cypherable getCypher(CypherType type) throws Throwable {
		if (type == CypherType.Asysmmetric) {
			return new AsymmetricCypher(Cipher.getInstance("RSA/ECB/PKCS1Padding"), "RSA", 2048);
		}
		else {
			return new SymmetricCypher(Cipher.getInstance("AES/ECB/PKCS1Padding"), "AES", 128);
		}
	}
}
