package assign2;

public class EncryptionTester {
	
	public static void testSet1()
	{
			Encryptor e1 = new Encryptor (0);
			Encryptor e2 = new Encryptor (3);
			Encryptor e3 = new Encryptor (11);
			Encryptor e4 = new Encryptor (25);
			Encryptor e5 = new Encryptor (26);
			
			String s1 = "abcdefghijklmnopqrstuvwxyz";
			String s2 = "Jordan Murtiff";
			String s3 = "Xray defraction";
			String s4 = "Zebra-tailed lizard";
			String s5 = "Walkie-talkie";
			String s6 = "COEN 275 OO Analysis, Design and Programming";
			
			System.out.println();
			System.out.println("Print statements for Encryptor Object with offset 0:");
			String e1EncryptS1 = e1.encrypt(s1);
			System.out.println(e1EncryptS1);
			System.out.println(e1.decrypt(e1EncryptS1));
			
			String e1EncryptS2 = e1.encrypt(s2);
			System.out.println(e1EncryptS2);
			System.out.println(e1.decrypt(e1EncryptS2));
			
			String e1EncryptS3 = e1.encrypt(s3);
			System.out.println(e1EncryptS3);
			System.out.println(e1.decrypt(e1EncryptS3));
			
			String e1EncryptS4 = e1.encrypt(s4);
			System.out.println(e1EncryptS4);
			System.out.println(e1.decrypt(e1EncryptS4));
			
			String e1EncryptS5 = e1.encrypt(s5);
			System.out.println(e1EncryptS5);
			System.out.println(e1.decrypt(e1EncryptS5));
			
			String e1EncryptS6 = e1.encrypt(s6);
			System.out.println(e1EncryptS6);
			System.out.println(e1.decrypt(e1EncryptS6));
			
			
			System.out.println();
			System.out.println("Print statements for Encryptor Object with offset 3:");
			String e2EncryptS1 = e2.encrypt(s1);
			System.out.println(e2EncryptS1);
			System.out.println(e2.decrypt(e2EncryptS1));
			
			String e2EncryptS2 = e2.encrypt(s2);
			System.out.println(e2EncryptS2);
			System.out.println(e2.decrypt(e2EncryptS2));
			
			String e2EncryptS3 = e2.encrypt(s3);
			System.out.println(e2EncryptS3);
			System.out.println(e2.decrypt(e2EncryptS3));
			
			String e2EncryptS4 = e2.encrypt(s4);
			System.out.println(e2EncryptS4);
			System.out.println(e2.decrypt(e2EncryptS4));
			
			String e2EncryptS5 = e2.encrypt(s5);
			System.out.println(e2EncryptS5);
			System.out.println(e2.decrypt(e2EncryptS5));
			
			String e2EncryptS6 = e2.encrypt(s6);
			System.out.println(e2EncryptS6);
			System.out.println(e2.decrypt(e2EncryptS6));
			
	}
	
	public static void testSet2()
	{
		int randomOffset1 = (int)(Math.random() * 25 + 1);
		int randomOffset2 = (int)(Math.random() * 25 + 1);
		int randomOffset3 = (int)(Math.random() * 25 + 1);
		int randomOffset4 = (int)(Math.random() * 25 + 1);
		System.out.println(randomOffset1);
		System.out.println(randomOffset2);
		System.out.println(randomOffset3);
		System.out.println(randomOffset4);
		
		Encryptor e1 = new Encryptor (randomOffset1);
		Encryptor e2 = new Encryptor (randomOffset2);
		Encryptor e3 = new Encryptor (randomOffset3);
		Encryptor e4 = new Encryptor (randomOffset4);
		
		String s1 = "abcdefghijklmnopqrstuvwxyz";
		String s2 = "Jordan Murtiff";
		String s3 = "Xray defraction";
		String s4 = "Zebra-tailed lizard";
		String s5 = "Walkie-talkie";
		String s6 = "COEN 275 OO Analysis, Design and Programming";
		
		System.out.println();
		System.out.println("Print statements for Encryptor Object #1 with random offset:");
		String e1EncryptS1 = e1.encrypt(s1);
		System.out.println(e1EncryptS1);
		System.out.println(e1.decrypt(e1EncryptS1));
		
		String e1EncryptS2 = e1.encrypt(s2);
		System.out.println(e1EncryptS2);
		System.out.println(e1.decrypt(e1EncryptS2));
		
		String e1EncryptS3 = e1.encrypt(s3);
		System.out.println(e1EncryptS3);
		System.out.println(e1.decrypt(e1EncryptS3));
		
		String e1EncryptS4 = e1.encrypt(s4);
		System.out.println(e1EncryptS4);
		System.out.println(e1.decrypt(e1EncryptS4));
		
		String e1EncryptS5 = e1.encrypt(s5);
		System.out.println(e1EncryptS5);
		System.out.println(e1.decrypt(e1EncryptS5));
		
		String e1EncryptS6 = e1.encrypt(s6);
		System.out.println(e1EncryptS6);
		System.out.println(e1.decrypt(e1EncryptS6));
		
		
	}
	
	public static void main(String[] args) 
	{
		testSet1();
		testSet2();
	}

}
