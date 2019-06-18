package modelObjects;

public class Accounts {
	
	int balance=50;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void withDraw(int amount)
	{
		balance= balance-amount;
	}

}
