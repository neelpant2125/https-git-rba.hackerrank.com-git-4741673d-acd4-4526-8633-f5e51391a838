package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.pin=pin;
		this.balance=startingDeposit;
	}

	public AccountHolder getAccountHolder() {
		// complete the function
        return accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		if(pin==attemptedPin)
        return true;
		else return false;
	}

	public double getBalance() {
		// complete the function
        return balance;
	}

	public Long getAccountNumber() {
		// complete the function
        return accountNumber;
	}

	public void creditAccount(double amount) {
		this.balance=this.balance+amount;
	}

	public boolean debitAccount(double amount) {
		if(this.balance<=0 || this.balance<amount)
			return false;
		
		else this.balance=this.balance-amount;
        return true;
	}
}
