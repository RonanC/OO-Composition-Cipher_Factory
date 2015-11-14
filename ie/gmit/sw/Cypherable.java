package ie.gmit.sw;

import java.security.Key;

public interface Cypherable {
	/**
	 * Weired whacky stuff
	 * @param plainText
	 * @return
	 * @throws Throwable
	 */
	
	public abstract byte[] encrypt(byte[] plainText) throws Throwable;

	public abstract byte[] decrypt(byte[] cypherText) throws Throwable;

	public abstract Key getKey();

	public abstract void setKey(Key key);

}