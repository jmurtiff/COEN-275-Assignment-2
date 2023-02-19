package assign2;

import java.util.Vector;

/**
 * Name: Jordan Murtiff
 * Course Number: COEN 275 – Object Oriented Analysis Design Programming
 * Assignment Number: Homework Assignment #2
 * Date of Submission: February 18th, 2023
 * 
 * @author Jordan Murtiff
 * @version 1.0
 * 
 * This is the ATM class, which defines the blueprint for ATM objects that hold 3 data members. 
 * An ATM can call addAccount() in order to create an instance of a BankAccount object and add it to the Vector 
 * collection data member "accounts" with an encrypted password. Additionally, an ATM can call getMoney() which
 * withdraws (subtracts) money from the balance of a BankAccount instance inside of "accounts" Vector given the 
 * correct account ID and password for the account.
 */
public class ATM {
	
	/**
	 * The accounts data member is a Vector object that holds all instances of BankAccount associated 
	 * with a given instance of ATM. The assignment does not specify what collection type has to be used 
	 * and as such I have chosen to use a Vector type collection.
	 */
	private Vector <BankAccount> accounts;
	
	/**
	 * The passwordEncoder data member is an instance of Encryptor that is used to encrypt the password of a
	 * instance of BankAccount using the Caesar Cipher algorithm. In order to utilize the encrypt() and 
	 * decrypt() functions of the Encryptor class, we need to utilize an instance of the Encryptor class 
	 * or else we would have to inherit these functions.
	 */
	private Encryptor passwordEncoder;
	
	/**
	 * The firstElement data member is used to see if an instance of BankAccount has already been added to the 
	 * "accounts" vector for an instance of ATM. This is used to see whether or not we should iterate through the 
	 * "accounts" vector to check for duplicate accounts (accounts with the same acctId) and if there are no instances
	 * of BankAccount in the "accounts" vector then we can safely add the new instance of BankAccount. Additionally, if 
	 * the getMoney() function is called we can see if there are any accounts added to the "accounts" vector and if there are
	 * not then we do not withdraw any money (as there are no accounts to withdraw from). This data member is not 
	 * directly included in the assignment, but it helps in checking for edge cases.
	 */
	private int firstElement;
	
	/**
	 * The default constructor for the ATM class. Since the assignment did not specify what the default
	 * constructor is supposed to do, I made it so that it sets the size of the Vector collection "accounts"
	 * to a value of 10 and the offset used for the passwordEncoder instance to a value of 10. Also, firstElement
	 * is set to a value of 0 as the first element of the "accounts" vector has not yet been added when the ATM 
	 * object is first instantiated.
	 */ 
	public ATM()
	{
		accounts = new Vector<BankAccount>(10);
		passwordEncoder = new Encryptor(10);
		firstElement = 0;
	}
	
	/**
	 * The addAccount class method for the ATM class. This function takes in the same four parameters that is necessary
	 * to create an instance of the BankAccount class (account ID, name, balance, and password) and adds a new instance of the 
	 * BankAccount class to the "accounts" Vector (assuming that valid values for the BankAccount instance were given or that the
	 * parameter value for account ID is not the same account ID as another BankAccount instance already in the "accounts" Vector).
	 * 
	 * If the passed String for the account ID is either an empty string or a null value, then we print out a message to the 
	 * user and return. This is because without a valid account number it is impossible to search for an already pre-existing 
	 * instance of BankAccount in the "accounts" Vector to ensure that the accountID of the new account is not the same as a 
	 * pre-existing account in the Vector. 
	 * 
	 * This function takes in three strings for accndId, name, and password, as well as a double for balance and generates an 
	 * instance of BankAccount with the values of accndId, name, balance, and the encrypted value of password utilizing the 
	 * Caesar Cipher algorithm. If the values passed for any of the three String arguments (accndId, name, and balance) is 
	 * either an empty string or null value then the constructor of BankAccount will throw an Illegal Argument Exception. 
	 * Additionally, if the value passed for balance is either a negative value or less than the value of the static variable
	 * minimumBalance found in the BankAccount class, then the constructor of BankAccount will also throw an Illegal Argument 
	 * Exception.
	 * 
	 * If this function is called and the "accounts" vector is empty, then as long as there is valid parameter values, a new 
	 * BankAccount instance will be appended to the "accounts" vector with an encrypted password. However, if the "accounts" 
	 * vector is not empty, then the function will iterate through all instances of BankAccount in the "accounts" Vector and see
	 * whether or not an instance of BankAccount shares the same account ID as the parameter value of acctId, if it does then
	 * a message is printed to the user and the function is returned, and if it is not, then the instance of BankAccount is created
	 * and appended to the "accounts" Vector.
	 * 
	 * The reason I choose to code print functions instead of including Illegal Argument Exceptions here in the ATM class is because 
	 * of the functionality of this program. Even though the test cases in the main function of ATM will not include these cases, 
	 * for normal functionality of the program it seems to be a good idea to make it clear to the user that certain cases are 
	 * not accepted, and as such it is easer to tell the user through print statements instead of throwing exceptions.
	 * 
	 * Again, like with the BankAccount class, it is difficult to write this code as the assignment does not make it 
	 * explicitly clear what is to be done in these edge cases of incorrect inputs, so I am using my best judgment and applying
	 * most of the logic for exceptions to the BankAccount class rather than the ATM class (as there is very little 
	 * purpose in re-writing exceptions that will apply for both classes).
	 * 
	 * @param accndId the account ID value of the BankAccount instance as a String, used to search for existing instances 
	 * @param name the name of the owner of the BankAccount instance as a String
	 * @param balance the current balance of the BankAccount instance as a double
	 * @param password the password to access the BankAccount instance as a String, encrypted with Caesar Cipher algorithm
	 */ 
	public void addAccount(String acctId, String name, double balance, String password)
	{
		boolean accndIdEmptyOrNull = (acctId == null || acctId.length() == 0);
		if(accndIdEmptyOrNull)
		{
			System.out.println("Without a valid account number, we cannot search to see if the account already exists"
					+ " in the ATM. Please add an account to the ATM with a valid account number.");
			return;
		}
		if(firstElement == 0)
		{
			String encryptedPassword = passwordEncoder.encrypt(password);
			BankAccount newAccount = new BankAccount(acctId, name, balance, encryptedPassword);
			accounts.add(newAccount);
			firstElement = 1;
		}
		else
		{
			int accountsLength = accounts.size();
			for(int i = 0; i < accountsLength; i++)
			{
				BankAccount temp = accounts.get(i);
				if(temp.getAccntId() == acctId)
				{
					System.out.println("The account you are trying to add already exists, please add a new account"
							+ " with a different account ID number.");
					return;
				}
			}
			String encryptedPassword = passwordEncoder.encrypt(password);
			BankAccount newAccount = new BankAccount(acctId, name, balance, encryptedPassword);
			accounts.add(newAccount);
		}
	}
	
	/**
	 * The getMoney() class method for the ATM class. This function takes in three parameters (account ID, amount, and password) 
	 * and tries to withdraw (or subtract) the passed value of amount from an instance of BankAccount in the "accounts" Vector
	 * that matches the passed values of account ID and password. 
	 * 
	 * If the passed String for the account ID and/or password is either an empty string or a null value, then we print out 
	 * a message to the user and return. This is because without a valid account number and/or password it is impossible 
	 * to search for an already pre-existing instance of BankAccount in the "accounts" Vector and withdraw from this account (as
	 * we can't find a instance of BankAccount without a valid account ID and we can't access the instance of BankAccount without
	 * the correct password).
	 * 
	 * If this function is called and the "accounts" vector is empty, then we print out to the user that we cannot withdraw from any
	 * BankAccount instances (as there are none to withdraw from). If the password given is incorrect (but an instance of BankAccount with
	 * the passed account ID does exist) then the user is printed a message saying that the password is wrong. And finally, if there are 
	 * no instances of BankAccount in the "accounts" vector that matched the passed value of account ID, then a message is printed to the 
	 * user saying that the given account does not exist.
	 * 
	 * The reason I choose to code print functions instead of including Illegal Argument Exceptions here in this method is because 
	 * of the test cases used in the main() function. There is a instance in the main() function of the ATM class where an account 
	 * with the correct ID, but incorrect password is called with the getMoney() function. If I were to throw an IllegalArgumentException 
	 * in this function then the other test cases would not be executed and it would be difficult to prove the normal functionality
	 * of the ATM class.
	 * 
	 * Again, like with the BankAccount class, it is difficult to write this code as the assignment does not make it 
	 * explicitly clear what is to be done in these edge cases of incorrect inputs, so I am using my best judgment and applying
	 * most of the logic for exceptions to the BankAccount class (for the withdraw function in this case) rather than the ATM class 
	 * (as there is very little purpose in re-writing exceptions that will apply for both classes).
	 * 
	 * @param accndId the account ID value of the BankAccount instance as a String, used to search for existing instances 
	 * @param amount the amount we wish to withdraw from one of the instances of BankAccount in the "accounts" vector as a double
	 * @param password the password to access the BankAccount instance as a String, encrypted with Caesar Cipher algorithm
	 * @return the amount withdrawn from one of the instances of BankAccount stored in the "accounts" vector
	 */ 
	public double getMoney(String acctId, String password, double amount)
	{
		boolean accndIdEmptyOrNull = (acctId == null || acctId.length() == 0);
		boolean passwordIdEmptyOrNull = (password == null || password.length() == 0);
		if(accndIdEmptyOrNull || passwordIdEmptyOrNull)
		{
			System.out.println("Without a valid account number or password, we cannot search to see if the account already exists"
					+ " or access the BankAccount even if it does exist in the ATM. Withdrawl from ATM has failed.");
			return 0.0;
		}
		if(firstElement != 0)
		{
			int accountsLength = accounts.size();
			for(int i = 0; i < accountsLength; i++)
			{
				BankAccount temp = accounts.get(i);
				if(temp.getAccntId() == acctId)
				{
					String decryptedPassword = passwordEncoder.decrypt(temp.getPassword());
					//We have to ignore upper or lower case as we don't know whether the user has passed the password 
					//in all lowercase or all uppercase (or a combination) and the encrypted password is already in all
					//uppercase due to the Caesar Cipher algorithm.
					if(decryptedPassword.equalsIgnoreCase(password))
					{
						double withdrawnMoney = temp.withdraw(amount);
						return withdrawnMoney;
					}
					else
					{
						System.out.println("Incorrect password was given, withdrawl from ATM has failed.");
						return 0.0;
					}
				}
			}
			System.out.println("Account does not exist, withdrawl from ATM has failed.");
			return 0.0;
		}
		else
		{
			System.out.println("No accounts exist yet, cannot withdraw from an ATM with no BankAccounts added.");
			return 0.0;
		}
	}

	/**
	 * The main function tests the addAccount() and getMoney() functions implemented in the ATM class.
	 * These test cases are taken directly from Homework Assignment #2.
	 */
	public static void main(String[] args) 
	{
		ATM a1 = new ATM ();
		a1.addAccount("A123", "M.Jones", 2000.00, "fall-quarter");
		System.out.println("Account ID is: " + a1.accounts.get(0).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(0).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(0).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(0).getName());
		System.out.println();
		
		a1.addAccount("B654", "B.Smith", 100.00, "renaissance");
		System.out.println("Account ID is: " + a1.accounts.get(1).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(1).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(1).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println("getMoney() has returned: " + a1.getMoney("A123", "fall-quarter", 1000.00));
		System.out.println("Account ID is: " + a1.accounts.get(0).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(0).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(0).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(0).getName());
		System.out.println();
		
		System.out.println("getMoney() has returned: " + a1.getMoney("B654", "essence", 100.00));
		System.out.println("Account ID is: " + a1.accounts.get(1).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(1).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(1).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println("getMoney() has returned: " + a1.getMoney("B654", "renaissance", 50.00));
		System.out.println("Account ID is: " + a1.accounts.get(1).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(1).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(1).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println("getMoney() has returned: " + a1.getMoney("B654", "renaissance", 50.00));
		System.out.println("Account ID is: " + a1.accounts.get(1).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(1).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(1).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println("getMoney() has returned: " + a1.getMoney("B654", "renaissance", 50.00));
		System.out.println("Account ID is: " + a1.accounts.get(1).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(1).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(1).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println("getMoney() has returned: " + a1.getMoney("B654", "renaissance", 50.00));
		System.out.println("Account ID is: " + a1.accounts.get(1).getAccntId());
		System.out.println("Account Password is: " + a1.accounts.get(1).getPassword());
		System.out.println("Account Balance is: " + a1.accounts.get(1).getBalance());
		System.out.println("Account Name is: " + a1.accounts.get(1).getName());
		System.out.println();
		
		a1.addAccount("A123", "M.Jones", 1000.00, "fall-quarter");		
	}

}
