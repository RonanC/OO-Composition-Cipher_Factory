package ie.gmit.sw;

import java.security.*;

import javax.crypto.*;

public class AsymmetricCypher extends AbstractCypher {
	private KeyPair keyRing;

	public AsymmetricCypher(Cipher c, String algorithm, int bits) throws Throwable {
		super(c);
		// generate a keypair (Dependency, they disappear once the method ends)
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
		keyGen.initialize(bits);
		keyRing = keyGen.generateKeyPair();
		
		//cypher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	}
	
	protected void finalize() throws Throwable {
		System.out.println("RSACypher about to be GCed");
	}

	protected void switchKey() throws Throwable {
		Key currentKey = super.getKey();
		
		if(currentKey instanceof PrivateKey) {
			super.setKey(keyRing.getPublic());
		}
		else{
			super.setKey(keyRing.getPrivate());
		}
	}	
	
}
