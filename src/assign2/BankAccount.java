package assign2;

public class BankAccount {
	
	private String accntId;
	
	private String name;
	
	private double balance;
	
	private String password;
	
	public BankAccount(String accndId, String name, double balance, String password)
	{
		if(accndId == "")
		{
			throw new IllegalArgumentException("Empty string for Account ID.");
		}
		else
		{
			this.accntId = accndId;
		}
		
		
		if(name == "")
		{
			throw new IllegalArgumentException("Empty string for Account Name.");
		}
		else
		{
			this.name = name;
		}
		
		
		if(Double.compare(balance, 0.0) < 0)
		{
			throw new IllegalArgumentException("BankAccount balance must be a positive value or 0.");
		}
		else
		{
			this.balance = balance;
		}
		
		
		if(password == "")
		{
			throw new IllegalArgumentException("Empty string for Account Password.");
		}
		else
		{
			this.password = password;
		}
		
	}
	
	public String getAccntId()
	{
		return this.accntId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public double withdraw(double amount)
	{
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
	
	public void deposit(double amount)
	{
		if (Double.compare(amount, 0.0) < 0)
		{
			System.out.println("Cannot deposit less than 0 dollars into a BankAccount object.");
		}
		else if(amount == 0)
		{
			System.out.println("Cannot deposit 0 dollars into a BankAccount object.");
		}
		else
		{
			this.balance = this.balance + amount;
		}
	}
	
	/*
	public static void main(String[] args) 
	{
		BankAccount b1 = new BankAccount ("001", "Jordan", 100, "password");
		System.out.println(b1.withdraw(0));
		System.out.println(b1.getBalance());
		
		
		System.out.println(b1.withdraw(-0.0));
		System.out.println(b1.getBalance());
		
		
		System.out.println(b1.withdraw(110));
		System.out.println(b1.getBalance());
		
		
		b1.deposit(-0.0);
		System.out.println(b1.getBalance());
		
		b1.deposit(0);
		System.out.println(b1.getBalance());
		
		
		b1.deposit(20);
		System.out.println(b1.getBalance());
	}*/
	
}
