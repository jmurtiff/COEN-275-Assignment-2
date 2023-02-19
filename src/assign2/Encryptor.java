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
 * This is the Encryptor class, which implements the Encryptable interface using the methodology of Caesar Cipher.
 */
public class Encryptor implements Encryptable {
	/**
	 * The offset data member is used to store the offset value set by the constructor
	 * or the setOffset() function. This value must be between the integers of 1 and 25 
	 * (as offsets of 0 and 26 would produce the same letters in the encrypt() function and
	 * the encryption would be entirely worthless). 
	 */
	private int offset;
	
	/**
	 * The default constructor for the Encryptor class. Since the assignment did not specify what the default
	 * constructor is supposed to do, I made it so that it sets the value of offset to a value of 1.
	 */ 
	public Encryptor()
	{
			this.offset = 1;
	}
	
	/**
	 * The parameterized constructor for the Encryptor class. This function takes in a value for the offset, checks 
	 * to see if its a value between 1 and 25, and sets the value of offset to the passed value. If the value passed
	 * if either 0 or 26, then the constructor will instead print out a message to the user warning them that the 
	 * encrypt and decrypt functions will not work unless they either set the offset to a value between 1 and 25 or
	 * if they create a new Encryptor instance with an offset between 1 and 25. After displaying the warning 
	 * message to the user, the constructor sets the value of offset to either a value of 0 or 26.
	 * 
	 * The reason I choose to code print functions instead of including an IllegalArgumentException is because 
	 * of the testing conditions that are to be included in the EncryptionTester class functions testSet1() and testSet2().
	 * If I were to throw an IllegalArgumentException in either of the 2 cases (offset of 0 or 26) then the other test
	 * cases would not be executed and it would be difficult to prove the normal functionality of the Encryptor class.
	 * 
	 * @param shift the value that offset will be set to
	 */ 
	public Encryptor(int shift)
	{
		if(shift > 0 && shift < 26)
		{
			this.offset = shift;
		}
		else
		{
			System.out.println("You have instantiated a Encryptor object with a offset of 0 or 26, the encrypt "
					+ "and decrypt functions will not work" + System.lineSeparator() + "for this object. Please set the Offset value to an "
					+ "integer between 1 and " + "25 or create a new instance of an" + System.lineSeparator() + "Encryptor object with an offset between 1 and 25.");
			this.offset = shift;
		}
	}
	
	/**
	 * The setter method for the offset data member. This function takes in a value for the offset, checks 
	 * to see if its a value between 1 and 25, and sets the value of offset to the passed value. If the value passed
	 * is either 0 or 26, then the function will instead print out a message to the user warning them that the 
	 * encrypt and decrypt functions will not work unless they either set the offset to a value between 1 and 25.
	 * After displaying the warning message to the user, the function sets the value of offset to either a value 
	 * of 0 or 26.
	 * 
	 * The reason I choose to code print functions instead of including an IllegalArgumentException is because 
	 * of the testing conditions that are to be included in the EncryptionTester class functions testSet1() and testSet2().
	 * If I were to throw an IllegalArgumentException in either of the 2 cases (offset of 0 or 26) then the other test
	 * cases would not be executed and it would be difficult to prove the normal functionality of the Encryptor class.
	 * 
	 * @param shift the value that offset will be set to
	 */ 
	public void setOffset(int shift)
	{
		if(shift > 0 && shift < 26)
		{
			this.offset = shift;
		}
		else
		{
			System.out.println("You have set the Offset for an Encryptor object with a value of 0 or 26, the encrypt "
					+ "and decrypt functions" + System.lineSeparator() + "will not work for this object. Please set a different value for the offset "
					+ "to a value between 1 and 25.");
			this.offset = shift;
		}
	}
	
	/**
	 * The encrypt member function. This function takes in a string as a parameter and changes each character
	 * to its uppercase equivalent (except symbols that are kept the same) and substitutes each letter in the original 
	 * string based on the value of the offset data member. This method is based on the Caesar cipher encryption algorithm.
	 * 
	 * If the value for offset is either 0 or 26, then the function will instead print out a message to the user 
	 * telling them that the encrypt function will not work and return an empty string. Additionally, if the 
	 * string being passed is the empty string or has a value of null, the function will print out a similar message
	 * telling the user that the encrypt function does not work for empty or null strings, and return an empty string.
	 * 
	 * In the case where a passed string is either null or of length 0 AND the offset of the Encryptor object is either
	 * 0 or 26, we should technically print out both messages, however for the sake of stopping the user it is easier
	 * if we instead just warn the user about the offset values and stop there, as there is no reason to continue checking whether 
	 * or not the passed string is empty or null as the encrypt function will not work anyways.
	 * 
	 * The reason I choose to code print functions instead of including an IllegalArgumentException is because 
	 * of the testing conditions that are to be included in the EncryptionTester class functions testSet1() and testSet2().
	 * If I were to throw an IllegalArgumentException in either of the 2 cases (offset of 0 or 26) then the other test
	 * cases would not be executed and it would be difficult to prove the normal functionality of the Encryptor class.
	 * It is difficult to write this code as the assignment does not make it explicitly clear what is to be done in these
	 * cases.
	 * 
	 * @param plaintext the string to be encrypted using Caesar Cipher 
	 * @return the encrypted string, in all uppercase characters with non-letters & symbols kept the same
	 */ 
	public String encrypt(String plaintext)
	{
		//Check if offset is 0 or 26, if so tell the user and return an empty string.
		if(this.offset == 0 || this.offset == 26)
		{
			System.out.println("The encrypt function does not work for offsets of 0 and 26.");
			return "";
		}
		//Check if the passed string is null or the empty string, if so tell the user and return an empty string.
		boolean emptyOrNull = (plaintext == null || plaintext.length() == 0);
		if(emptyOrNull)
		{
			System.out.println("The encrypt function does not work for empty or null strings.");
			return "";
		}
		else
		{
			//The original string is converted to all uppercase characters and we 
			//get the length of the original string so we can traverse all characters
			//of the string.
			int length = plaintext.length();
			String upperCase = plaintext.toUpperCase();
			String finalString = "";
			
			//For the entire string we check to see if each character is a letter, if
			//it is, we substitute it based on the Caesar Cipher algorithm and append it 
			//to the final encrypted string. If the character is not a letter (a symbol or 
			//whitespace) then we add append it to the encrypted string without any substitution.
			for (int i = 0; i < length; i++)
			{
				if(Character.isLetter(upperCase.charAt(i)))
				{
					int originalAlphabetPosition = upperCase.charAt(i) - 'A';
					int newAlphabetPosition = (originalAlphabetPosition + this.offset) % 26;
					char encryptedLetter = (char) ('A' + newAlphabetPosition);
					finalString = finalString + encryptedLetter;
				}
				else
				{
					finalString = finalString + upperCase.charAt(i);
				}
			}
			return finalString;
		}
	}
	
	/**
	 * The decrypt member function. This function takes in a string as a parameter and changes each character
	 * to its uppercase equivalent (except symbols that are kept the same) and substitutes each letter in the passed 
	 * string to its original character (before encryption) based on the value of the offset data member. 
	 * This method is based on the Caesar cipher encryption algorithm.
	 * 
	 * If the value for offset is either 0 or 26, then the function will instead print out a message to the user 
	 * telling them that the decrypt function will not work and return an empty string. Additionally, if the 
	 * string being passed is the empty string or has a value of null, the function will print out a similar message
	 * telling the user that the decrypt function does not work for empty or null strings, and return an empty string.
	 * 
	 * In the case where a passed string is either null or of length 0 AND the offset of the Encryptor object is either
	 * 0 or 26, we should technically print out both messages, however for the sake of stopping the user it is easier
	 * if we instead just warn the user about the offset values and stop there, as there is no reason to continue checking whether 
	 * or not the passed string is empty or null as the decrypt function will not work anyways.
	 * 
	 * The reason I choose to code print functions instead of including an IllegalArgumentException is because 
	 * of the testing conditions that are to be included in the EncryptionTester class functions testSet1() and testSet2().
	 * If I were to throw an IllegalArgumentException in either of the 2 cases (offset of 0 or 26) then the other test
	 * cases would not be executed and it would be difficult to prove the normal functionality of the Encryptor class.
	 * It is difficult to write this code as the assignment does not make it explicitly clear what is to be done in these
	 * cases.
	 * 
	 * @param encryptedString the string to be decrypted using Caesar Cipher 
	 * @return the decrypted string, in all uppercase characters with non-letters & symbols kept the same
	 */ 
	public String decrypt(String encryptedText)
	{
		//Check if offset is 0 or 26, if so tell the user and return an empty string.
		if(this.offset == 0 || this.offset == 26)
		{
			System.out.println("The decrypt function does not work for offsets of 0 and 26.");
			return "";
		}
		//Check if the passed string is null or the empty string, if so tell the user and return an empty string.
		boolean emptyOrNull = (encryptedText == null || encryptedText.length() == 0);
		if(emptyOrNull)
		{
			System.out.println("The decrypt function does not work for empty or null strings.");
			return "";
		}
		else
		{
			//The passed string is converted to all uppercase characters and we 
			//get the length of the original string so we can traverse all characters.
			//Even though the passed string is supposed to contain all uppercase characters (as we 
			//should be using the return value of the encrypt() function) for the sake of making
			//it more complete, we will assume that the passed string may or may not be uppercase and 
			//make it uppercase anyways. This helps ensure that the string is correctly decrypted
			//given the Caesar Cipher algorithm.
			int length = encryptedText.length();
			String upperCase = encryptedText.toUpperCase();
			String finalString = "";
			
			//For the entire string we check to see if each character is a letter, if
			//it is, we substitute it based on the Caesar Cipher algorithm and append it 
			//to the final encrypted string. If the character is not a letter (a symbol or 
			//whitespace) then we add append it to the encrypted string without any substitution.
			for (int i = 0; i < length; i++)
			{
				if(Character.isLetter(upperCase.charAt(i)))
				{
					int decryptedLetter = (upperCase.charAt(i) - 'A' + (26 - this.offset)) % 26 + 'A';
					char encryptedLetter = (char) decryptedLetter;
					finalString = finalString + encryptedLetter;
				}
				else
				{
					finalString = finalString + upperCase.charAt(i);
				}
			}
			return finalString;
		}
	}
	
	/*
	public static void main(String[] args) 
	{
		//Encryptor e1 = new Encryptor (0);
		//Encryptor e2 = new Encryptor (3);
		Encryptor e3 = new Encryptor (0);
		String s1 = null;
		String test = e3.encrypt(s1);
		System.out.println(test);
		System.out.println(e3.decrypt(test));
		e3.setOffset(26);
		
	}*/

}
