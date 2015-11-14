package ie.gmit.sw;

import javax.crypto.Cipher;

public class TestRunner {
	// asymmetric cipher
	// key pair
	
	// symmetric cipher
	// single key (bit shift possibly)
	
	public static void main(String[] args) throws Throwable{
		/*	
		 * 	Encapsulate object creation! N/A
		 */	
		
		CypherFactory fac = CypherFactory.getInstance();
		// new keyword gone, which makes this a more loosely coupled api
		Cypherable rsac = fac.getCypher(CypherType.Asysmmetric); //new AsymmetricCypher(Cipher.getInstance("RSA/ECB/PKCS1Padding"), "RSA", 2048);
		byte[] result;
		String plainText = "Happy Days!";
		
		// Encrypt
		result = rsac.encrypt(plainText.getBytes("UTF-8"));	// char is 16 bits, we chose 8 here
		System.out.println("Enc: " + new String(result));
		
		// Decrypt
		result = rsac.decrypt(result);
		System.out.println("Dec: " + new String(result));		
	}

}
