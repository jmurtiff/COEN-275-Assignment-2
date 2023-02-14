package assign2;

import java.util.Vector;

public class ATM {
	
	private Vector <BankAccount> accounts;
	
	private Encryptor passwordEncoder;
	
	private static int firstElement = 0;
	
	public ATM()
	{
		accounts = new Vector<BankAccount>(10);
		
		//What should the offset for passwordEncoder be, should it be 1 or a random value between
		//1 and 25?
		passwordEncoder = new Encryptor();
	}
	
	public void addAccount(String acctId, String name, double balance, String password)
	{
		//Should we check that valid values of acctId, name, balance, and password exist here, that 
		//way if the user creates a bankAccount that does not make sense, we catch it here instead of 
		//in the constructor of BankAccount.
		
		//Should check if the account already exists in the Vector "accounts", if it does then
		//we do not add the account at all.
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
	
	public double getMoney(String acctId, String password, double amount)
	{
		int accountsLength = accounts.size();
		for(int i = 0; i < accountsLength; i++)
		{
			BankAccount temp = accounts.get(i);
			if(temp.getAccntId() == acctId)
			{
				String decryptedPassword = passwordEncoder.decrypt(temp.getPassword());
				if(decryptedPassword.equalsIgnoreCase(password))
				{
					double withdrawnMoney = temp.withdraw(amount);
					return withdrawnMoney;
				}
				else
				{
					System.out.println("Incorrect password case");
					return 0.0;
				}
			}
		}
		System.out.println("Account does not exist case");
		return 0.0;
	}

	public static void main(String[] args) 
	{
		ATM a1 = new ATM ();
		a1.addAccount("A123", "M.Jones", 2000.00, "fall-quarter");
		System.out.println(a1.accounts.get(0).getAccntId());
		System.out.println(a1.accounts.get(0).getPassword());
		System.out.println(a1.accounts.get(0).getBalance());
		System.out.println(a1.accounts.get(0).getName());
		System.out.println();
		
		
		
		a1.addAccount("B654", "B.Smith", 100.00, "renaissance");
		
		System.out.println(a1.accounts.get(1).getAccntId());
		System.out.println(a1.accounts.get(1).getPassword());
		System.out.println(a1.accounts.get(1).getBalance());
		System.out.println(a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println(a1.getMoney("A123", "fall-quarter", 1000.00));
		System.out.println(a1.accounts.get(0).getAccntId());
		System.out.println(a1.accounts.get(0).getPassword());
		System.out.println(a1.accounts.get(0).getBalance());
		System.out.println(a1.accounts.get(0).getName());
		System.out.println();
		
		System.out.println(a1.getMoney("B654", "essence", 100.00));
		System.out.println(a1.accounts.get(1).getAccntId());
		System.out.println(a1.accounts.get(1).getPassword());
		System.out.println(a1.accounts.get(1).getBalance());
		System.out.println(a1.accounts.get(1).getName());
		System.out.println();
		
		
		System.out.println(a1.getMoney("B654", "renaissance", -0.00));
		System.out.println(a1.accounts.get(1).getAccntId());
		System.out.println(a1.accounts.get(1).getPassword());
		System.out.println(a1.accounts.get(1).getBalance());
		System.out.println(a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println(a1.getMoney("B654", "renaissance", -50.00));
		System.out.println(a1.accounts.get(1).getAccntId());
		System.out.println(a1.accounts.get(1).getPassword());
		System.out.println(a1.accounts.get(1).getBalance());
		System.out.println(a1.accounts.get(1).getName());
		System.out.println();
		
		System.out.println(a1.getMoney("B654", "renaissance", 50.00));
		System.out.println(a1.accounts.get(1).getAccntId());
		System.out.println(a1.accounts.get(1).getPassword());
		System.out.println(a1.accounts.get(1).getBalance());
		System.out.println(a1.accounts.get(1).getName());
		System.out.println();
		
		a1.addAccount("A123", "M.Jones", 1000.00, "fall-quarter");
		
	}

}
