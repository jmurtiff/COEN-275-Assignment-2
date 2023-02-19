package assign2;

/**
 * Name: Jordan Murtiff
 * Course Number: COEN 275 – Object Oriented Analysis Design Programming
 * Assignment Number: Homework Assignment #2
 * Date of Submission: February 18th, 2023
 * 
 * @author Jordan Murtiff
 * @version 1.0
 * 
 * This is the EncryptionTester class, which creates instances of Encryptor and tests the functionality of the 
 * encrypt and decrypt class methods.
 */
public class EncryptionTester {
	
	/**
	 * The first test function for testing the functionality of the Encryptor class. In this function we create
	 * a single instance of Encryptor and we encrypt and decrypt a series of six pre-determined strings from the 
	 * assignment to ensure correct functionality of the encrypt and decrypt functions. All offsets used for encryption
	 * and decryption are set manually through the setOffset() function and are given in the assignment. These offset values
	 * are 0, 3, 11, 25, and 26.
	 * 
	 * For every encryption and decryption pair, the original string that is supposed to be encrypted is shown first in order
	 * to easily check correct functionality. 
	 */
	public static void testSet1()
	{
		Encryptor e1 = new Encryptor (0);
		System.out.println();
			
		String s1 = "abcdefghijklmnopqrstuvwxyz";
		String s2 = "Jordan Murtiff";
		String s3 = "Xray defraction";
		String s4 = "Zebra-tailed lizard";
		String s5 = "Walkie-talkie";
		String s6 = "COEN 275 OO Analysis, Design and Programming";
			
		System.out.println("Print statements for Encryptor Object with offset of 0:");
		String e1EncryptS1 = e1.encrypt(s1);
		e1.decrypt(e1EncryptS1);
		
		String e1EncryptS2 = e1.encrypt(s2);
		e1.decrypt(e1EncryptS2);
		
		String e1EncryptS3 = e1.encrypt(s3);
		e1.decrypt(e1EncryptS3);
			
		String e1EncryptS4 = e1.encrypt(s4);
		e1.decrypt(e1EncryptS4);
			
		String e1EncryptS5 = e1.encrypt(s5);
		e1.decrypt(e1EncryptS5);
		
		String e1EncryptS6 = e1.encrypt(s6);
		e1.decrypt(e1EncryptS6);
			
			
		e1.setOffset(3);
		System.out.println();
		System.out.println("Print statements for Encryptor Object with offset of 3:");
		String e1EncryptS1Offset3 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1Offset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1Offset3));
		System.out.println();
		
		String e1EncryptS2Offset3 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2Offset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2Offset3));
		System.out.println();
	
		String e1EncryptS3Offset3 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3Offset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3Offset3));
		System.out.println();
		
		String e1EncryptS4Offset3 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4Offset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4Offset3));
		System.out.println();
			
		String e1EncryptS5Offset3 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5Offset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5Offset3));
		System.out.println();
			
		String e1EncryptS6Offset3 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6Offset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6Offset3));
		System.out.println();
			
			
		e1.setOffset(11);
		System.out.println();
		System.out.println("Print statements for Encryptor Object with offset of 11:");
		String e1EncryptS1Offset11 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1Offset11);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1Offset11));
		System.out.println();
			
		String e1EncryptS2Offset11 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2Offset11);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2Offset11));
		System.out.println();
			
		String e1EncryptS3Offset11 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3Offset11);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3Offset11));
		System.out.println();
			
		String e1EncryptS4Offset11 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4Offset11);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4Offset11));
		System.out.println();
			
		String e1EncryptS5Offset11 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5Offset11);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5Offset11));
		System.out.println();
			
		String e1EncryptS6Offset11 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6Offset11);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6Offset11));
		System.out.println();
			
			
		e1.setOffset(25);
		System.out.println();
		System.out.println("Print statements for Encryptor Object with offset of 25:");
		String e1EncryptS1Offset25 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1Offset25);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1Offset25));
		System.out.println();
			
		String e1EncryptS2Offset25 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2Offset25);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2Offset25));
		System.out.println();
			
		String e1EncryptS3Offset25 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3Offset25);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3Offset25));
		System.out.println();
			
		String e1EncryptS4Offset25 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4Offset25);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4Offset25));
		System.out.println();
			
		String e1EncryptS5Offset25 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5Offset25);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5Offset25));
		System.out.println();
			
		String e1EncryptS6Offset25 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6Offset25);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6Offset25));
		System.out.println();
			
			
		e1.setOffset(26);
		System.out.println();
		System.out.println("Print statements for Encryptor Object with offset of 26:");
		String e1EncryptS1Offset26 = e1.encrypt(s1);
		e1.decrypt(e1EncryptS1Offset26);
		
		String e1EncryptS2Offset26 = e1.encrypt(s2);
		e1.decrypt(e1EncryptS2Offset26);
		
		String e1EncryptS3Offset26 = e1.encrypt(s3);
		e1.decrypt(e1EncryptS3Offset26);
			
		String e1EncryptS4Offset26 = e1.encrypt(s4);
		e1.decrypt(e1EncryptS4Offset26);
			
		String e1EncryptS5Offset26 = e1.encrypt(s5);
		e1.decrypt(e1EncryptS5Offset26);
			
		String e1EncryptS6Offset26 = e1.encrypt(s6);
		e1.decrypt(e1EncryptS6Offset26);
	}
	
	/**
	 * The second test function for testing the functionality of the Encryptor class. In this function we create
	 * a single instance of Encryptor and we encrypt and decrypt a series of six pre-determined strings from the 
	 * assignment to ensure correct functionality of the encrypt and decrypt functions. All offsets used for encryption
	 * are randomly generated integers from 1 to 25 inclusive and are set manually through the setOffset() function.
	 * 
	 * For every encryption and decryption pair, the original string that is supposed to be encrypted is shown first in order
	 * to easily check correct functionality. 
	 */
	public static void testSet2()
	{
		int randomOffset1 = (int)(Math.random() * 25 + 1);
		int randomOffset2 = (int)(Math.random() * 25 + 1);
		int randomOffset3 = (int)(Math.random() * 25 + 1);
		int randomOffset4 = (int)(Math.random() * 25 + 1);
		
		Encryptor e1 = new Encryptor (randomOffset1);
		
		String s1 = "abcdefghijklmnopqrstuvwxyz";
		String s2 = "Jordan Murtiff";
		String s3 = "Xray defraction";
		String s4 = "Zebra-tailed lizard";
		String s5 = "Walkie-talkie";
		String s6 = "COEN 275 OO Analysis, Design and Programming";
		
		System.out.println();
		System.out.println("Print statements for Encryptor Object #1 with random offset:");
		System.out.println("Random offset value is: " + randomOffset1);
		String e1EncryptS1RandomOffset1 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1RandomOffset1);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1RandomOffset1));
		System.out.println();
		
		String e1EncryptS2RandomOffset1 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2RandomOffset1);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2RandomOffset1));
		System.out.println();
		
		String e1EncryptS3RandomOffset1 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3RandomOffset1);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3RandomOffset1));
		System.out.println();
		
		String e1EncryptS4RandomOffset1 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4RandomOffset1);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4RandomOffset1));
		System.out.println();
		
		String e1EncryptS5RandomOffset1 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5RandomOffset1);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5RandomOffset1));
		System.out.println();
		
		String e1EncryptS6RandomOffset1 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6RandomOffset1);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6RandomOffset1));
		System.out.println();
		
		
		e1.setOffset(randomOffset2);
		System.out.println();
		System.out.println("Print statements for Encryptor Object #2 with random offset:");
		System.out.println("Random offset value is: " + randomOffset2);
		String e1EncryptS1RandomOffset2 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1RandomOffset2);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1RandomOffset2));
		System.out.println();
		
		String e1EncryptS2RandomOffset2 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2RandomOffset2);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2RandomOffset2));
		System.out.println();
		
		String e1EncryptS3RandomOffset2 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3RandomOffset2);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3RandomOffset2));
		System.out.println();
		
		String e1EncryptS4RandomOffset2 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4RandomOffset2);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4RandomOffset2));
		System.out.println();
		
		String e1EncryptS5RandomOffset2 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5RandomOffset2);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5RandomOffset2));
		System.out.println();
		
		String e1EncryptS6RandomOffset2 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6RandomOffset2);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6RandomOffset2));
		System.out.println();
		
		
		e1.setOffset(randomOffset3);
		System.out.println();
		System.out.println("Print statements for Encryptor Object #3 with random offset:");
		System.out.println("Random offset value is: " + randomOffset3);
		String e1EncryptS1RandomOffset3 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1RandomOffset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1RandomOffset3));
		System.out.println();
		
		String e1EncryptS2RandomOffset3 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2RandomOffset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2RandomOffset3));
		System.out.println();
		
		String e1EncryptS3RandomOffset3 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3RandomOffset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3RandomOffset3));
		System.out.println();
		
		String e1EncryptS4RandomOffset3 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4RandomOffset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4RandomOffset3));
		System.out.println();
		
		String e1EncryptS5RandomOffset3 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5RandomOffset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5RandomOffset3));
		System.out.println();
		
		String e1EncryptS6RandomOffset3 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6RandomOffset3);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6RandomOffset3));
		System.out.println();
		
		
		e1.setOffset(randomOffset4);
		System.out.println();
		System.out.println("Print statements for Encryptor Object #4 with random offset:");
		System.out.println("Random offset value is: " + randomOffset4);
		String e1EncryptS1RandomOffset4 = e1.encrypt(s1);
		System.out.println("Original String: " + s1);
		System.out.println("Encrypted String: " + e1EncryptS1RandomOffset4);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS1RandomOffset4));
		System.out.println();
		
		String e1EncryptS2RandomOffset4 = e1.encrypt(s2);
		System.out.println("Original String: " + s2);
		System.out.println("Encrypted String: " + e1EncryptS2RandomOffset4);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS2RandomOffset4));
		System.out.println();
		
		String e1EncryptS3RandomOffset4 = e1.encrypt(s3);
		System.out.println("Original String: " + s3);
		System.out.println("Encrypted String: " + e1EncryptS3RandomOffset4);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS3RandomOffset4));
		System.out.println();
		
		String e1EncryptS4RandomOffset4 = e1.encrypt(s4);
		System.out.println("Original String: " + s4);
		System.out.println("Encrypted String: " + e1EncryptS4RandomOffset4);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS4RandomOffset4));
		System.out.println();
		
		String e1EncryptS5RandomOffset4 = e1.encrypt(s5);
		System.out.println("Original String: " + s5);
		System.out.println("Encrypted String: " + e1EncryptS5RandomOffset4);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS5RandomOffset4));
		System.out.println();
		
		String e1EncryptS6RandomOffset4 = e1.encrypt(s6);
		System.out.println("Original String: " + s6);
		System.out.println("Encrypted String: " + e1EncryptS6RandomOffset4);
		System.out.println("Decrypted String: " + e1.decrypt(e1EncryptS6RandomOffset4));
		System.out.println();
	}
	
	/**
	 * The main function calls both test functions implemented above.
	 */
	public static void main(String[] args) 
	{
		testSet1();
		testSet2();
	}

}
