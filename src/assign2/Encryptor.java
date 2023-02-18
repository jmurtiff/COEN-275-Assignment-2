package assign2;

public class Encryptor implements Encryptable {
	
	private int offset;
	
	public Encryptor()
	{
			this.offset = 1;
	}
	
	public Encryptor(int shift)
	{
		if(shift > 0 && shift < 26)
		{
			this.offset = shift;
		}
		else
		{
			//Should we throw an exception, because if we do then the rest of the test cases will not execute. 
			//throw new IllegalArgumentException();
			System.out.println("You have instantiated a Encryptor object with a offset of 0 or 26, the encrypt "
					+ "and decrypt functions will not work for this object. Please set the Offset value between 1 and "
					+ "25 or create a new instance of an Encryptor object with an offset between 1 and 25.");
			this.offset = shift;
		}
	}
	
	public void setOffset(int shift)
	{
		if(shift > 0 && shift < 26)
		{
			this.offset = shift;
		}
		else
		{
			System.out.println("You have set the Offset for an Encryptor object with a value of 0 or 26, the encrypt "
					+ "and decrypt functions will not work for this object. Please set a different value for offset "
					+ "between 1 and 25.");
			this.offset = shift;
		}
	}
	
	public String encrypt (String plaintext)
	{
		if(this.offset == 0 || this.offset == 26)
		{
			return "The encrypt function does not work for offsets of 0 and 26.";
		}
		else
		{
			int length = plaintext.length();
			String upperCase = plaintext.toUpperCase();
			String finalString = "";
			for (int i = 0; i < length; i++)
			{
				if(Character.isLetter(upperCase.charAt(i)))
				{
					int originalAlphabetPosition = upperCase.charAt(i) - 'A';
					int newAlphabetPosition = (originalAlphabetPosition + this.offset) % 26;
					char encrypted_letter = (char) ('A' + newAlphabetPosition);
					finalString = finalString + encrypted_letter;
				}
				else
				{
					//we append it to the final encrypted string
					finalString = finalString + upperCase.charAt(i);
				}
			}
			return finalString;
		}
	}
	
	public String decrypt (String encryptedText)
	{
		if(this.offset == 0 || this.offset == 26)
		{
			return "The decrypt function does not work for offsets of 0 and 26.";
		}
		else
		{
			int length = encryptedText.length();
			String upperCase = encryptedText.toUpperCase();
			String finalString = "";
			for (int i = 0; i < length; i++)
			{
				if(Character.isLetter(upperCase.charAt(i)))
				{
					int decrypted_letter = (upperCase.charAt(i) - 'A' + (26 - this.offset)) % 26 + 'A';
					char encrypted_letter = (char) decrypted_letter;
					finalString = finalString + encrypted_letter;
				}
				else
				{
					finalString = finalString + upperCase.charAt(i);
				}
			}
			return finalString;
		}
	}
}
