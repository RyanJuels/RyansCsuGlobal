

public class CheckingAccount extends BankAccount{
	
	private double interestRate;
	
	public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
		super(firstName, lastName, accountID);
		this.interestRate = interestRate;
	}
	
	public void processWithdrawal(double amount) {
        withdraw(amount);
        if(getBalance() < 0) {
            withdraw(30);
            System.out.println("You have overdrafted. The fee will be $30");
            System.out.printf("New Balance: $%.2f\n", getBalance());
        }
    }
	
	public void displayAccount() {
        accountSummary();
        System.out.printf("Interest Rate: %.2f%s \n", getInterestRate(), "%");
    }
	
	
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
