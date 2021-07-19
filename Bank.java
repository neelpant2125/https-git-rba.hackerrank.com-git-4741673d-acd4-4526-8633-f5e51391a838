package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private Random accntNumGenerator;

	public Bank() {
		accntNumGenerator=new Random();
		accounts=new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		if(accounts.isEmpty() || !accounts.containsKey(accountNumber))
			return null;
		else return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {

		CommercialAccount commercialAccnt=new CommercialAccount(company, accntNumGenerator.nextLong(), pin, startingDeposit);
		accounts.put(commercialAccnt.getAccountNumber(), commercialAccnt);
		return commercialAccnt.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		ConsumerAccount consumerAccnt=new ConsumerAccount(person, accntNumGenerator.nextLong(), pin, startingDeposit);
		accounts.put(consumerAccnt.getAccountNumber(), consumerAccnt);
		return consumerAccnt.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account acnt=getAccount(accountNumber);
		if(acnt!=null) return acnt.validatePin(pin);
		return false;
	}

	public double getBalance(Long accountNumber) {
		Account acnt=getAccount(accountNumber);
		
		if(acnt!=null)return acnt.getBalance();
		return -1.0;
	}

	public void credit(Long accountNumber, double amount) {
		Account acnt=getAccount(accountNumber);
		if(acnt!=null) acnt.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account acnt=getAccount(accountNumber);
		if(acnt!=null) return acnt.debitAccount(amount);
		return false;
	}
}
