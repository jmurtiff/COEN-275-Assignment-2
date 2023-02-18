package assign2;

/**
 * Name: Jordan Murtiff
 * Course Number: COEN 275 – Object Oriented Analysis Design Programming
 * Assignment Number: Homework Assignment #2
 * Date of Submission: February 18th, 2023
 * 
 * This is an interface for the encrypt and decrypt functions implemented in the Encryptor class.
 */
public interface Encryptable {
	   /**
	   * This method will be used to encrypt a string using the Caesar Cipher method
	   * @param text the string to be encrypted using Caesar Cipher 
	   * @return the encrypted string, in all uppercase characters with non-letters & symbols kept the same
	   */
	String encrypt (String text);
	
	   /**
	   * This method will be used to decrypt a string using the Caesar Cipher method
	   * @param text the string to be decrypted using Caesar Cipher 
	   * @return the original string that was encrypted, in all uppercase characters with non-letters & symbols kept the same
	   */
	String decrypt (String text);
}
