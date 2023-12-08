

public class TestAccounts {

	public static void main(String[] args) {
		String firstName = "Ryan";
        String lastName = "Juelsgaard";
        int accountID = 1154826;
        double interestRate = 5.26;
        

        System.out.println("Bank Account Class: ");
        BankAccount bankAccount = new BankAccount(firstName, lastName, accountID);
        bankAccount.deposit(1500.00);
        bankAccount.accountSummary();
        System.out.println("\nWithdrawing $526.34");
        bankAccount.withdraw(526.34);
        bankAccount.accountSummary();


        System.out.println("\n\nChacking Account Class: ");
        CheckingAccount checkingAccount = new CheckingAccount(firstName, lastName, accountID, interestRate);
        checkingAccount.deposit(1500.00);
        checkingAccount.displayAccount();
        System.out.println("\nWithdrawing $500");
        checkingAccount.processWithdrawal(500.00);
        checkingAccount.displayAccount();
        checkingAccount.processWithdrawal(1500.00);

	}

}
