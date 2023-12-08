

public class BankAccount {
	private String firstName;
    private String lastName;
    private int accountID;
    private double balance;
	public BankAccount(String firstName, String lastName, int accountID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0;
	}
    
	public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void accountSummary() {
        System.out.printf("Name: %s %s\n", getFirstName(), getLastName());
        System.out.println("AccountID:  " + getAccountID());
        System.out.printf("Balance:    $%.2f\n", getBalance());
    }
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public double getBalance() {
		return balance;
	}
	
	
}
