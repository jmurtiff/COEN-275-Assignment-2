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
	}
	
	public void setOffset(int shift)
	{
		if(shift > 0 && shift < 26)
		{
			this.offset = shift;
		}
	}
	
	public String encrypt (String plaintext)
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
	
	public String decrypt (String encryptedText)
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
	
	public static void main(String[] args) 
	{
		Encryptor e1 = new Encryptor (1);
		System.out.println(e1.encrypt("This is a test!"));
		System.out.println(e1.decrypt("Uijt jt b uftu!"));
	}
	
}
