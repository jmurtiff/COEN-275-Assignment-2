package assign2;

import java.math.BigDecimal;

/**
 * Name: Jordan Murtiff
 * Course Number: COEN 275 – Object Oriented Analysis Design Programming
 * Assignment Number: Homework Assignment #2
 * Date of Submission: February 18th, 2023
 * 
 * @author Jordan Murtiff
 * @version 1.0
 * 
 * This is the BankAccount class, which defines the blueprint for BankAccount objects that hold four data
 * members and one shared data member. A BankAccount can withdraw() (to decrease the balance of the account) and
 * can deposit() (to increase the balance of the account). Instances of BankAccount can have the same content for
 * accntId, name, balance, and password.
 */
public class BankAccount {
	
	/**
	 * The account ID data member is used to store the string that makes up the ID value for a given
	 * BankAccount instance.
	 */
	private String accntId;
	
	/**
	 * The name data member is used to store the string that makes up the name of the owner of a
	 * BankAccount instance.
	 */
	private String name;
	
	/**
	 * The balance data member is used to store the current balance of a BankAccount instance. This 
	 * value cannot be a negative number nor can it be lower than the value of "minimumBalance" when the 
	 * BankAccount instance is created. After the instance is generated, however, the balance of the account
	 * can be at a minimum 0.00.
	 */
	private double balance;
	
	/**
	 * The password data member is used to store the string that makes up the password of the BankAccount instance.
	 */
	private String password;
	
	/**
	 * The minimum balance data member is shared between all instances of BankAccount. This value is not required in the
	 * assignment, however, when opening a BankAccount there is usually a 
	 */
	private static double minimumBalance = 10.00;
	
	/**
	 * The default constructor for the BankAccount class. Since the assignment did not specify what the default
	 * constructor is supposed to do, I made it so that it sets the value of accntID, name, and password to Strings 
	 * of "A" and the balance to the value of minimumBalance.
	 */ 
	public BankAccount()
	{
		accntId = "A";
		name = "A";
		balance = minimumBalance;
		password = "A";
	}
	
	/**
	 * The parameterized constructor for the BankAccount class. This function takes in three strings for accndId,
	 * name, and password, as well as a double for balance and sets the value of these data members. If the value passed
	 * for any of the three String arguments (accndId, name, and balance) is either an empty string or null value
	 * then the constructor throws an Illegal Argument Exception. Additionally, if the value passed for balance 
	 * is either a negative value or less than the value of the static variable minimumBalance, then the constructor 
	 * also throws an Illegal Argument Exception.
	 * 
	 * The reason I choose to include Illegal Argument Exceptions instead of print statements is because of the test cases
	 * that are included in the main function of the ATM class. None of the test cases include empty or null strings or balance
	 * values less than 10.00, and as such it is okay to throw exceptions as this will not cause test cases to break or not execute.
	 * 
	 * @param accndId the account ID value of the BankAccount instance as a String
	 * @param name the name of the owner of the BankAccount instance as a String
	 * @param balance the current balance of the BankAccount instance as a double
	 * @param password the password to access the BankAccount instance as a String
	 */ 
	public BankAccount(String accndId, String name, double balance, String password)
	{
		boolean accndIdEmptyOrNull = (accndId == null || accndId.length() == 0);
		if(accndIdEmptyOrNull)
		{
			throw new IllegalArgumentException("Empty or null string for Account ID.");
		}
		else
		{
			this.accntId = accndId;
		}
		
		boolean nameEmptyOrNull = (name == null || name.length() == 0);
		if(nameEmptyOrNull)
		{
			throw new IllegalArgumentException("Empty or null string for Account Name.");
		}
		else
		{
			this.name = name;
		}
		
		if(Double.compare(balance, 0.0) < 0 || balance < minimumBalance)
		{
			throw new IllegalArgumentException("BankAccount balance cannot be a negative value or be below the "
					+ "minimum balance value of $10.00.");
		}
		else
		{
			this.balance = balance;
		}
		
		boolean passwordEmptyOrNull = (password == null || password.length() == 0);
		if(passwordEmptyOrNull)
		{
			throw new IllegalArgumentException("Empty or null string for Account Password.");
		}
		else
		{
			this.password = password;
		}
		
	}
	
	/**
	 * The accessor class method for the accntId data member.
	 * 
	 * @return the Account ID of a BankAccount object as a String
	 */ 
	public String getAccntId()
	{
		return this.accntId;
	}
	
	/**
	 * The accessor class method for the name data member.
	 * 
	 * @return the name of a BankAccount object as a String
	 */ 
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * The accessor class method for the name data member.
	 * 
	 * @return the balance of a BankAccount object as a double
	 */ 
	public double getBalance()
	{
		return this.balance;
	}
	
	/**
	 * The accessor class method for the password data member.
	 * 
	 * @return the password of a BankAccount object as a String
	 */ 
	public String getPassword()
	{
		return this.password;
	}
	
	/**
	 * The withdraw class method for the BankAccount class. This function takes in a double as an amount to subtract from
	 * the balance of a given BankAccount instance. 
	 * 
	 * If the value passed for amount is greater than 2 decimal places (such as 10.000) or is a negative value or 0 (since
	 * you cannot take a negative value or 0 out of a normal Bank Account) then the function prints out a message to the user and return 
	 * a value of 0 for all three cases (as no money has been withdrawn from the account). Additionally, if the value passed
	 * for amount is greater than the value of balance, again print out a message to the user and return a value of 0. 
	 * If none of the above cases apply to the passed value of amount, the value of amount is subtracted from
	 * the balance data member of the BankAccount instance and this amount is returned as a double.
	 * 
	 * The reason I choose to code print functions instead of including Illegal Argument Exceptions is because 
	 * of the functionality of this program. Even though the test cases in the main function of ATM will not include these cases, 
	 * for normal functionality of the program it seems to be a good idea to make it clear to the user that certain cases are 
	 * not accepted, and as such it is easer to tell the user through print statements instead of throwing exceptions.
	 * 
	 * Again, like with the Encryptor class, it is difficult to write this code as the assignment does not make it 
	 * explicitly clear what is to be done in these edge cases of incorrect inputs, so I am using my best judgment.
	 * 
	 * @param amount the amount to be subtracted from the balance of a BankAccount object as a double
	 * @return the amount subtracted from the balance data member as a double
	 */ 
	public double withdraw(double amount)
	{
		if(BigDecimal.valueOf(amount).scale() > 2)
		{
			System.out.println("Cannot withdraw an amount that includes more than 2 decimal places. Please withdraw an amount that"
					+ " includes up to 2 decimal places such as 10.00 instead of 10.000.");
			return 0;
		}
		if (Double.compare(amount, 0.0) < 0)
		{
			System.out.println("Cannot withdraw less than 0 dollars from a BankAccount object.");
			return 0;
		}
		if(amount == 0)
		{
			System.out.println("Cannot withdraw 0 dollars from a BankAccount object.");
			return 0;
		}
		if(amount > this.balance)
		{
			System.out.println("The amount to withdraw is larger than the current balance of the account, please"
					+ " withdraw a smaller amount from the account");
			return 0;
		}
		this.balance = this.balance - amount;
		return amount;
	}

	/**
	 * The deposit class method for the BankAccount class. This function takes in a double as an amount to add to
	 * the balance of a given BankAccount instance. 
	 * 
	 * If the value passed for amount is greater than 2 decimal places (such as 10.000) or is a negative value or 0 (since
	 * you cannot add a negative value or 0 into a normal Bank Account) then the function prints out a message to the user
	 * and returns. If none of the above cases apply to the passed value of amount, the value of amount is added
	 * to the balance data member of the BankAccount instance.
	 * 
	 * The reason I choose to code print functions instead of including Illegal Argument Exceptions is because 
	 * of the functionality of this program. Even though the test cases in the main function of ATM will not include these cases, 
	 * for normal functionality of the program it seems to be a good idea to make it clear to the user that certain cases are 
	 * not accepted, and as such it is easer to tell the user through print statements instead of throwing exceptions.
	 * 
	 * Again, like with the Encryptor class, it is difficult to write this code as the assignment does not make it 
	 * explicitly clear what is to be done in these edge cases of incorrect inputs, so I am using my best judgment.
	 * 
	 * @param amount the amount to be added to the balance of a BankAccount object as a double
	 */ 
	public void deposit(double amount)
	{
		if(BigDecimal.valueOf(amount).scale() > 2)
		{
			System.out.println("Cannot withdraw an amount that includes more than 2 decimal places.");
			return;
		}
		if (Double.compare(amount, 0.0) < 0)
		{
			System.out.println("Cannot deposit less than 0 dollars into a BankAccount object.");
			return;
		}
		if(amount == 0)
		{
			System.out.println("Cannot deposit 0 dollars into a BankAccount object.");
			return;
		}
			this.balance = this.balance + amount;
	}
	
	
	/*
	public static void main(String[] args) 
	{
		BankAccount b1 = new BankAccount ("001", "Jordan", 100, "password");
		System.out.println(b1.withdraw(0.00));
		System.out.println(b1.getBalance());
		
		
		System.out.println(b1.withdraw(80));
		System.out.println(b1.getBalance());
		
		
		System.out.println(b1.withdraw(110));
		System.out.println(b1.getBalance());
		
		
		b1.deposit(-0.0);
		System.out.println(b1.getBalance());
		
		b1.deposit(0);
		System.out.println(b1.getBalance());
		
		b1.deposit(20);
		System.out.println(b1.getBalance());
		b1.deposit(20.011);
		System.out.println(b1.getBalance());
	}*/
	
}
